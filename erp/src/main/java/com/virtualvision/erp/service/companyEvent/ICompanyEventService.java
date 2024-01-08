package com.virtualvision.erp.service.companyEvent;

import java.util.List;

import com.virtualvision.erp.domain.CompanyEvent;
import com.virtualvision.erp.domain.Sale;

public interface ICompanyEventService {

    List<CompanyEvent> findAllCompanyEvents();

    CompanyEvent findCompanyEventById(Long id);

    void saveCompanyEvent(CompanyEvent event);

    void deleteCompanyEvent(Long id);

    Sale getSaleWithDetails(Long id);
    
}
