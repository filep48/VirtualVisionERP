package com.virtualvision.erp.service;

import java.util.List;

import com.virtualvision.erp.domain.Customer;




public interface ICustomerService {
    List<Customer> customersList();
    void saveCustomer(Customer customer);
    void deleteCustomer(Long id);
    Customer findCustomerId(Long id);
    void updateCustomerWithoutPassword(Customer customer);


    
}
