package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.virtualvision.erp.domain.CompanyEvent;

public interface ICompanyEventDao extends JpaRepository<CompanyEvent, Long> {

    
}
