package com.virtualvision.erp.service.rrhh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.UserContext;
import com.virtualvision.erp.service.employee.IEmployeeService;

@Service
public class HoursService {

    private IEmployeeService employeeService;
    @Autowired
    private UserContext userContext;

    public HoursService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void addDailyHours(Double addhours, Employee employee) {
        if (employee.getHours() == null) {
            employee.setHours(0.0);
        }
        employee.setHours(employee.getHours() + addhours);
        employeeService.saveEmployee(employee);

    }

    public double getTotalHours(Employee employee) {
        if (employee.getHours() == null) {
            employee.setHours(0.0);
        }
        return employee.getHours();
    }
}
