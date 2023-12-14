package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.virtualvision.erp.domain.Product;

public interface IProdructDao extends JpaRepository<Product, Long>{
    
    
}
