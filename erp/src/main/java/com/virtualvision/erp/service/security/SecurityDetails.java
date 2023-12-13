package com.virtualvision.erp.service.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.dao.ICustomerDao;
import com.virtualvision.erp.dao.IEmployeeDao;
import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.UserContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SecurityDetails implements UserDetailsService {
    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private IEmployeeDao employeeDao;
    @Autowired
    private UserContext userContext;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerDao.findByUsername(username);
        Employee employee;

        if (customer != null) {

            userContext.setName(customer.getName());
            userContext.setSurname(customer.getSurname());
            userContext.setEmail(customer.getEmail());
            userContext.setPhone(customer.getPhone());
            userContext.setAddress(customer.getAddress());
            userContext.setUserType("Customer");

            return new User(username, customer.getPassword(), Collections.emptyList());
        } else {
            employee = employeeDao.findByUsername(username);
            if (employee == null) {
                throw new UsernameNotFoundException("User not found");
            }
            userContext.setName(employee.getName());
            userContext.setSurname(employee.getSurname());
            userContext.setEmail(employee.getEmail());
            userContext.setPhone(employee.getPhone());
            userContext.setAddress(employee.getAddress());
            userContext.setUserType("Employee");

            return new User(username, employee.getPassword(), Collections.emptyList());
        }
    }

    public UserContext getUserContext() {
        return userContext;
    }

}
