package com.virtualvision.erp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualvision.erp.dao.ICustomerDao;
import com.virtualvision.erp.domain.Customer;

import lombok.extern.slf4j.Slf4j;

@Service("userDetailsService")
@Slf4j
public class CustomerServiceImp implements UserDetailsService, ICustomerService {

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
    public void deleteCustomer(Long id) {
        customerDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Customer findCustomerId(Long id) {
        return customerDao.findById(id).orElse(null);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerDao.findByUsername(username);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public ArrayList<Customer> FindAll() {
        return (ArrayList<Customer>) customerDao.findAll();
    }

    @Override
    @Transactional(readOnly = true) // Consulta només de lectura
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer usuari = customerDao.findByUsername(username);

        // Comprobamos que existe el usuario
        if (usuari == null) {
            throw new UsernameNotFoundException(username);
        }

        // Creamos una lista para almacenar los roles (en este caso, solo uno)
        List<GrantedAuthority> rols = new ArrayList<>();

        // Añadimos el rol del usuario a la lista de GrantedAuthority
        rols.add(new SimpleGrantedAuthority("ROLE_" + usuari.getRole()));

        log.info(usuari.getUsername());
        log.info(usuari.getPassword());
        log.info(rols.get(0).getAuthority());

        // Devolvemos el nuevo usuario de tipo UserDetails
        return new User(usuari.getUsername(), usuari.getPassword(), rols);
    }

    @Override
    public boolean saveCustomerLogin(Customer customer) {
        try {
            customerDao.save(customer);
            return true;
        } catch (Exception e) {
            log.error("Error al guardar el usuario: " + e.getMessage(), e);
            return false;
        }

    }

    public void updateCustomerWithoutPassword(Customer customerData) {
        Customer existingCustomer = customerDao.findById(customerData.getId()).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setName(customerData.getName());
            existingCustomer.setSurname(customerData.getSurname());
            existingCustomer.setUsername(customerData.getUsername());
            existingCustomer.setDniNif(customerData.getDniNif());
            existingCustomer.setPhone(customerData.getPhone());
            existingCustomer.setEmail(customerData.getEmail());
            existingCustomer.setRole(customerData.getRole());

            customerDao.save(existingCustomer);
        }
    }

    @Override
    public Long findIdByUsername(String username) {
        return customerDao.findIdByUsername(username);
    }

}