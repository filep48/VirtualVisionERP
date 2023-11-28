package com.virtualvision.erp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.dao.ICustomerDao;


@Service
public class CustomerServiceImp implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    public CustomerServiceImp(ICustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> customersList() {
        return customerDao.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findCustomer(Long id) {
        return customerDao.findById(id).orElse(null);
    }
    
}