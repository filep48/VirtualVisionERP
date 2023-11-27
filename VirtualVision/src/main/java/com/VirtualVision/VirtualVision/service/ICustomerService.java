package com.VirtualVision.VirtualVision.service;

import java.util.List;

import com.VirtualVision.VirtualVision.domain.Customer;




public interface ICustomerService {
    List<Customer> customersList();
    void save(Customer customer);
    void delete(Long id);
    Customer findCustomer(Long id);
}
