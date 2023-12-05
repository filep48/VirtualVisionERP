package com.virtualvision.erp.service.rrhh;

import java.util.List;

import com.virtualvision.erp.domain.Payroll;

public interface IrrhhService {
    List<Payroll> PayrollListById(Long id);

}
