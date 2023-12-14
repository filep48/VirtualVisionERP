package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.virtualvision.erp.domain.Product;

public interface IProductDao extends JpaRepository<Product, Long>{

    Product findByName(String name);
    
    Long findIdByName(String name);
}
