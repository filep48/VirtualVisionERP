package com.virtualvision.erp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualvision.erp.domain.Employee;

public interface IEmployeeDao extends JpaRepository<Employee, Long> {

    Employee findByUsername(String username);

}
