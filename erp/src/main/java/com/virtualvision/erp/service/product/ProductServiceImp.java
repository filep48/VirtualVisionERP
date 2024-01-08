package com.virtualvision.erp.service.product;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtualvision.erp.dao.IProductDao;
import com.virtualvision.erp.dao.ISupplierDao;
import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.domain.Sale;
import com.virtualvision.erp.domain.Supplier;
import com.virtualvision.erp.service.sale.ISaleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductDao productDao;
    @Autowired
    private ISupplierDao supplierDao;

    public ProductServiceImp(IProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Product> productList() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Product findProductById(Long id) {
        return productDao.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Product findByName(String name) {
        return productDao.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
public boolean saveProduct(Product product) {
    try {
        if (product.getSupplier() != null && product.getSupplier().getId() != null) {
            Supplier supplier = supplierDao.findById(product.getSupplier().getId()).orElse(null);
            product.setSupplier(supplier);
        }
        productDao.save(product);
        return true;
    } catch (Exception e) {
        log.error("Error al guardar el producto: " + e.getMessage(), e);
        return false;
    }
}

@Transactional
@Override
public void updateProductDetails(Product productData) {
    Product existingProduct = productDao.findById(productData.getId()).orElse(null);
    if (existingProduct != null) {
        // Actualiza los campos del producto
        existingProduct.setName(productData.getName());
        existingProduct.setDescription(productData.getDescription());
        existingProduct.setQuantity(productData.getQuantity());
        existingProduct.setPrice(productData.getPrice());

        // del proveedor
        if (productData.getSupplier() != null && productData.getSupplier().getId() != null) {
            Supplier supplier = supplierDao.findById(productData.getSupplier().getId()).orElse(null);
            existingProduct.setSupplier(supplier);
        }

        productDao.save(existingProduct);
    }
}


    @Override
    public Long findIdByName(String name) {
        return productDao.findIdByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> searchProducts(String query) {
        try {
            Long id = Long.parseLong(query);
            Product product = findProductById(id);
            return product != null ? Collections.singletonList(product) : Collections.emptyList();
        } catch (NumberFormatException e) {
            return findProductsByName(query);
        }
    }

    public List<Product> findProductsByName(String name) {
        return productDao.findByNameContaining(name);
    }

    @Override
    public List<Product> productListWithSuppliers() {
        return productDao.findAllWithSuppliers();
    }
    @Autowired
    private ISaleService saleService; 

    @Override
    @Transactional(readOnly = true)
    public int getTotalQuantitySoldByProduct(Long productId) {
        Product product = findProductById(productId);
        if (product != null) {
            List<Sale> sales = saleService.getSalesByProduct(product);
            int totalQuantitySold = 0;
            for (Sale sale : sales) {
                totalQuantitySold += sale.getQuantity();
            }
            return totalQuantitySold;
        }
        return 0;
    }

    public void updateProductQuantityAfterSale(Long productId, int quantitySold) {
        Product product = findProductById(productId);
        if (product != null && product.getQuantity() >= quantitySold) {
            int newQuantity = product.getQuantity() - quantitySold;
            product.setQuantity(newQuantity);
            save(product);
        } else {
            log.error("La cantidad vendida excede la cantidad disponible para el producto con ID: " + productId);
        }
    }
    


}
