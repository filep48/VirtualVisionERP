package com.virtualvision.erp.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.virtualvision.erp.domain.Payroll;

public interface IPayroll extends JpaRepository<Payroll, Long> {
    // crea un metodo que devuelve una lista de nóminas por el id del empleado
    @Query("select p from Payroll p where p.employee.id = ?1")
    List<Payroll> PayrollListById(Long id);

    // crea un metodo que devuelve una lista de 3 de nóminas por el id del empleado
    @Query("select p from Payroll p where p.employee.id = ?1 order by p.id desc")
    List<Payroll> PayrollListById3(Long id, Pageable pageable);

}