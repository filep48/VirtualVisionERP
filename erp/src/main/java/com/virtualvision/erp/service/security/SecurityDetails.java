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
import com.virtualvision.erp.service.context.UserContext;

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
        String password;
        if (customer == null) {
            Employee employee = employeeDao.findByUsername(username);
            if (employee == null) {
                throw new UsernameNotFoundException("User not found");
            }
            password = employee.getPassword();
        } else {
            password = customer.getPassword();
        }
        userContext.setName(customer.getName());
        return new User(username, password, Collections.emptyList());
    }

}
