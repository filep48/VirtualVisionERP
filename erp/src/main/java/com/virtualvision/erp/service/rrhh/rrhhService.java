package com.virtualvision.erp.service.rrhh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.dao.IPayroll;
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Payroll;
import com.virtualvision.erp.service.employee.IEmployeeService;

@Service
public class rrhhService implements IrrhhService {

    @Autowired
    private IPayroll payrollDao;

    @Autowired
    private IEmployeeService employeeService;

    // crea un contructor de payrollDao
    public rrhhService(IPayroll payrollDao) {
        this.payrollDao = payrollDao;
    }

    @Override
    public List<Payroll> PayrollListById(Long id) {
        return payrollDao.PayrollListById(id);
    }

    @Override
    public Payroll createPayroll(Payroll payroll) {
        return payrollDao.save(payroll);
    }

    @Override
    public void deletePayroll(Long id) {
        payrollDao.deleteById(id);
    }

    public String percentageData(Employee employee2) {
        // haz una peticion sql para saber cuantos campos tiene el empleado
        Employee employee = employeeService.findEmployeeId(employee2.getId());
        // datos: name, surname, email, dni, phone, address, position, salary, numSS
        int percentage = 0;
        if (!employee.getName().equals("") && employee.getName() != null) {
            percentage += 11;
        }
        if (!employee.getSurname().equals("") && employee.getSurname() != null) {
            percentage += 11;
        }
        if (!employee.getEmail().equals("") && employee.getEmail() != null) {
            percentage += 11;
        }
        if (!employee.getDniNif().equals("") && employee.getDniNif() != null) {
            percentage += 11;
        }
        if (!employee.getPhone().equals("") && employee.getPhone() != null) {
            percentage += 11;
        }
        if (!employee.getAddress().equals("") && employee.getAddress() != null) {
            percentage += 11;
        }
        if (!employee.getPosition().equals("") && employee.getPosition() != null) {
            percentage += 11;
        }
        if (employee.getSalary() == 0) {
            percentage += 11;
        }
        if (!employee.getNumSS().equals("") && employee.getNumSS() != null) {
            percentage += 11;
        }
        String percentageData = percentage + "%";
        return percentageData;
    }

    public String percentagehours(Double hours) {
        if (hours == null) {
            hours = 0.0;
        }
        double percentage = Math.min(100, (hours / 40.0) * 100);
        percentage = Math.round(percentage * 100.0) / 100.0;
        String percentageHours = String.valueOf(percentage);
        return percentageHours;
    }
}
