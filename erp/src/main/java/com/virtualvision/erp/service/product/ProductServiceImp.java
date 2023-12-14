package com.virtualvision.erp.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualvision.erp.dao.IProductDao;
import com.virtualvision.erp.domain.Product;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImp implements IProductService {

    @Autowired
    private IProductDao productDao;

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
    public boolean saveProductDetails(Product product) {
        try {
            productDao.save(product);
            return true;
        } catch (Exception e) {
            log.error("Error al guardar el producto: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public void updateProductDetails(Product productData) {
        Product existingProduct = productDao.findById(productData.getId()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(productData.getName());
            existingProduct.setDescription(productData.getDescription());
            existingProduct.setQuantity(productData.getQuantity());
            existingProduct.setPrice(productData.getPrice());

            productDao.save(existingProduct);
        }
    }

    @Override
    public Long findIdByName(String name) {
        return productDao.findIdByName(name);
    }

    @Override
    public void saveProduct(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveProduct'");
    }

}
