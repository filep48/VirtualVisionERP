package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualvision.erp.domain.Sale;

public interface ISaleDao extends JpaRepository<Sale, Long>{
    
}
