package com.virtualvision.erp.service.sale;

import java.util.List;

import com.virtualvision.erp.domain.Sale;

public interface ISaleService {
    
    List<Sale> findAllSales();

    void saveSale(Sale sale);

    Sale findSaleById(Long id);

    void deleteSale(Long id);
    
}
