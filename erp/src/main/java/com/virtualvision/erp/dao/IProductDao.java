package com.virtualvision.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualvision.erp.domain.Product;

public interface IProductDao extends JpaRepository<Product, Long> {

    Product findByName(String name);

    Long findIdByName(String name);

    List<Product> findByNameContaining(String name);


    //se usa JOIN FETCH para resolver el problema de la carga perezosa (lazy loading)
    //FETCH indica que los datos de supplier deben cargarse inmediatamente junto con cada Product.
    @Query("SELECT p FROM Product p JOIN FETCH p.supplier")
    List<Product> findAllWithSuppliers();
}
