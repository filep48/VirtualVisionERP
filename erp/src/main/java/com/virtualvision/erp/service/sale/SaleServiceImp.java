package com.virtualvision.erp.service.sale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.dao.ISaleDao;
import com.virtualvision.erp.domain.CompanyEvent;
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.domain.Sale;
import com.virtualvision.erp.service.companyEvent.ICompanyEventService;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.product.IProductService;

import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleServiceImp implements ISaleService {

    @Autowired
    private ISaleDao saleDao;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IProductService productService;

    @Autowired
    private ICompanyEventService companyEventService;

    @Transactional(readOnly = true)
    @Override
    public List<Sale> findAllSales() {
        List<Sale> sales = saleDao.findAll();
        for (Sale sale : sales) {
            if (sale.getEmployees() != null) {
                Hibernate.initialize(sale.getEmployees());
            }
            // PUEDE QUE NECESITE ESTO INICIALIZAR MAS ENTIDADES PARA LA CARGA PEREZOSA :(
        }
        return sales;
    }

    @Override
    public void saveSale(Sale sale) {
        saleDao.save(sale);
    }

    @Transactional(readOnly = true)
    @Override
    public Sale findSaleById(Long id) {
        Sale sale = saleDao.findById(id).orElse(null);
        if (sale != null && sale.getEmployees() != null) {
            Hibernate.initialize(sale.getEmployees());
        }
        return sale;
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

    public void addProductsToSale(Long saleId, List<Long> productIds) {
        Sale sale = findSaleById(saleId);
        if (sale != null) {
            Set<Product> selectedProducts = new HashSet<>();
            for (Long productId : productIds) {
                Product product = productService.findProductById(productId);
                if (product != null) {
                    selectedProducts.add(product);
                }
            }
            sale.getProducts().addAll(selectedProducts);
            saveSale(sale);
        }
    }

    public void addEventsToSale(Long saleId, List<Long> eventIds) {
        Sale sale = findSaleById(saleId);
        if (sale != null) {
            Set<CompanyEvent> selectedEvents = new HashSet<>();
            for (Long eventId : eventIds) {
                CompanyEvent event = companyEventService.findCompanyEventById(eventId);
                if (event != null) {
                    selectedEvents.add(event);
                }
            }
            sale.getEvents().addAll(selectedEvents);
            saveSale(sale);
        }
    }

    // public Sale findSaleWithDetails(Long id) {
    // return saleDao.findSaleWithDetails(id)
    // .orElseThrow(() -> new EntityNotFoundException("Venta no encontrada con ID: "
    // + id));

    // }

    // @Override
    // public Sale getSaleWithDetails(Long saleId) {
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getSaleWithDetails'");
    // }

}
