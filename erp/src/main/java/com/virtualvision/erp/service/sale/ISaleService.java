package com.virtualvision.erp.service.sale;

import java.util.List;

import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Sale;

public interface ISaleService {
    
    List<Sale> findAllSales();

    void saveSale(Sale sale);

    Sale findSaleById(Long id);

    void deleteSale(Long id);

    List<Employee> findEmployeesByIds(List<Long> employeeIds);

    void addProductsToSale(Long saleId, List<Long> selectedProducts);

    void addEventsToSale(Long saleId, List<Long> selectedEvents);



    //Sale getSaleWithDetails(Long saleId);
    
    //Sale findSaleWithDetails (Long saleId);
}
