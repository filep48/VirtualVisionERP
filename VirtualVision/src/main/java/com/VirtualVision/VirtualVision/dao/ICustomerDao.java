package com.VirtualVision.VirtualVision.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.VirtualVision.VirtualVision.domain.Customer;





public interface ICustomerDao extends JpaRepository <Customer, Long> {
    
}
