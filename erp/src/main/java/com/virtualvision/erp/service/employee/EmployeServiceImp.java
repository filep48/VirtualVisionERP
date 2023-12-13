package com.virtualvision.erp.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualvision.erp.dao.IEmployeeDao;
import com.virtualvision.erp.domain.Employee;

@Service
public class EmployeServiceImp implements IEmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> employeesList() {
        return employeeDao.findAll();

    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findEmployeeId(Long id) {
        return employeeDao.findById(id).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDao.deleteById(id);
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeDao.findByUsername(username);
    }

    @Override
    public Long findIdByUsername(String username) {
        return employeeDao.findIdByUsername(username);
    }

}
