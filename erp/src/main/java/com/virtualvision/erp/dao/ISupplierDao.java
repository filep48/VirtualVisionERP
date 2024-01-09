package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualvision.erp.domain.Supplier;



public interface ISupplierDao extends JpaRepository<Supplier, Long> {

        Supplier findByName(String name);

        
}
