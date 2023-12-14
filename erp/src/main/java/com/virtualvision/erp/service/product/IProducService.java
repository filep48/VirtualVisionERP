package com.virtualvision.erp.service.product;

import java.util.List;

import com.virtualvision.erp.domain.Product;

public interface IProducService {
    List<Product> productList();

    void save(Product product);

    void deleteProduct(Long id);

    Product findProductById(Long id);

    Product findByName(String name);

    void saveProduct(Product product);

    List<Product> findAll();

    boolean saveProductDetails(Product product);

    void updateProductDetails(Product product);

    Long findIdByName(String name);

}
