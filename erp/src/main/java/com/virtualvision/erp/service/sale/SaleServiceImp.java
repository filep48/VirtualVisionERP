package com.virtualvision.erp.service.sale;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.dao.ISaleDao;
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Sale;
import com.virtualvision.erp.service.employee.IEmployeeService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleServiceImp implements ISaleService {

    @Autowired
    private ISaleDao saleDao;

    @Autowired
    private IEmployeeService employeeService;


    @Transactional(readOnly = true)
    @Override
    public List<Sale> findAllSales() {
        return saleDao.findAll();
    }

    @Override
    public void saveSale(Sale sale) {
        saleDao.save(sale);
    }

    @Transactional(readOnly = true)
    @Override
    public Sale findSaleById(Long id) {
        return saleDao.findById(id).orElse(null);
    }

    @Override
    public void deleteSale(Long id) {
        saleDao.deleteById(id);
    }

    @Override
    public List<Employee> findEmployeesByIds(List<Long> employeeIds) {
        List<Employee> employees = new ArrayList<>();
        for (Long employeeId : employeeIds) {
            Employee employee = employeeService.findEmployeeId(employeeId);
            if (employee != null) {
                employees.add(employee);
            }
        }
        return employees; // Devuelve la lista de empleados encontrados
    }

}
