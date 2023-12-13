package com.virtualvision.erp.controller.rrhhController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtualvision.erp.dao.IPayroll;
import com.virtualvision.erp.domain.UserContext;

@Controller
public class rrhhController {
    @Autowired
    private IPayroll payrollService;

    @Autowired
    private UserContext userContext;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/rrhh")
    public String showPayrollsForEmployee() {
        
        return "/views/RRHH/RHPanel";
    }

}