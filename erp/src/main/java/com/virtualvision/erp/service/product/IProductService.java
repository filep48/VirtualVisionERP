package com.virtualvision.erp.service.product;

import java.util.List;

import com.virtualvision.erp.domain.Product;

public interface IProductService {
    List<Product> productList();

    void save(Product product);

    void deleteProduct(Long id);

    Product findProductById(Long id);

    Product findByName(String name);

    List<Product> findAll();

    boolean saveProduct(Product product);

    void updateProductDetails(Product product);

    Long findIdByName(String name);

    List<Product> searchProducts(String query);
    
    List<Product> productListWithSuppliers() ;

    int getTotalQuantitySoldByProduct(Long productId);

    void updateProductQuantityAfterSale(Long productId, int quantitySold);

    List<Product> productListwithOut0Stock();

    
}
