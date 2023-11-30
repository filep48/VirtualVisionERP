package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualvision.erp.domain.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

    Customer findByUsername(String username);

}
