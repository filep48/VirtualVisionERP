package com.virtualvision.erp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualvision.erp.domain.Payroll;

public interface IPayroll extends JpaRepository<Payroll, Long> {
    // crea un metodo que devuelve una lista de nóminas por el username del empleado
    @Query("SELECT p FROM Payroll p WHERE p.employee.id = ?1")
    List<Payroll> PayrollListById(Long id);
}