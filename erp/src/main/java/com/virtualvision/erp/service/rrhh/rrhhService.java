package com.virtualvision.erp.service.rrhh;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.virtualvision.erp.dao.IPayroll;
import com.virtualvision.erp.domain.Payroll;

public class rrhhService implements IrrhhService {

    @Autowired
    private IPayroll payrollDao;

    // crea un contructor de payrollDao
    public rrhhService(IPayroll payrollDao) {
        this.payrollDao = payrollDao;
    }

    @Override
    public List<Payroll> PayrollListById(Long id) {
        return payrollDao.PayrollListById(id);
    }

}
