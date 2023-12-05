package com.virtualvision.erp.service.sale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtualvision.erp.dao.ISaleDao;
import com.virtualvision.erp.domain.Sale;

import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleServiceImp implements ISaleService{

    @Autowired
    private ISaleDao saleDao;

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
    
}
