package com.virtualvision.erp.service;

import java.util.List;

import com.virtualvision.erp.domain.Customer;

public interface ICustomerService {

    List<Customer> customersList();

    void save(Customer customer);

    void deleteCustomer(Long id);

    Customer findCustomerId(Long id);

    Customer findByUsername(String username);

    void saveCustomer(Customer customer);

    List<Customer> FindAll();

    boolean saveCustomerLogin(Customer customer);

    void updateCustomerWithoutPassword(Customer customer);

    Long findIdByUsername(String username);

}
