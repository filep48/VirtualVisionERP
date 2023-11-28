package com.virtualvision.erp.service;

import java.util.List;

import com.virtualvision.erp.domain.Customer;




public interface ICustomerService {
    List<Customer> customersList();
    void save(Customer customer);
    void delete(Long id);
    Customer findCustomer(Long id);
}
