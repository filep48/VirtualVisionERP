package com.virtualvision.erp.service.companyEvent;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.virtualvision.erp.dao.ICompanyEventDao;
import com.virtualvision.erp.dao.ISaleDao;
import com.virtualvision.erp.domain.CompanyEvent;
import com.virtualvision.erp.domain.Sale;

@Service
public class CompanyEventServiceImpl implements ICompanyEventService {

    @Autowired
    private ICompanyEventDao companyEventDao;
    @Autowired
    private ISaleDao saleDao;

    @Transactional(readOnly = true)
    @Override
    public List<CompanyEvent> findAllCompanyEvents() {
        return companyEventDao.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public CompanyEvent findCompanyEventById(Long id) {
        CompanyEvent event = companyEventDao.findById(id).orElse(null);
        return event;
    }

    @Transactional
    @Override
    public void saveCompanyEvent(CompanyEvent event) {
        companyEventDao.save(event);
    }

    @Transactional
    @Override
    public void deleteCompanyEvent(Long id) {
        companyEventDao.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Sale getSaleWithDetails(Long id) {
        Sale sale = saleDao.findById(id).orElse(null);
        if (sale != null) {
            if (sale.getEmployees() != null) {
                sale.getEmployees().size();
            }
            if (sale.getProducts() != null) {
                sale.getProducts().size();
            }
            // si necesitamos cargar mas relaciones perezosas AQUI
        }
        return sale;
    }

}
