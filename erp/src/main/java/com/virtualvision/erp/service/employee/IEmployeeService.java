package com.virtualvision.erp.service.employee;

import java.util.List;

import com.virtualvision.erp.domain.Employee;

public interface IEmployeeService {

    List<Employee> employeesList();

    void saveEmployee(Employee employee);

    Employee findEmployeeId(Long id);

    void deleteEmployee(Long id);

    Employee findByUsername(String username);

    Long findIdByUsername(String username);

    

}