package com.virtualvision.erp.controller.rrhhController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtualvision.erp.dao.IPayroll;
import com.virtualvision.erp.domain.Payroll;
import com.virtualvision.erp.domain.UserContext;

@Controller
public class rrhhController {
    @Autowired
    private IPayroll payrollService;

    @Autowired
    private UserContext userContext;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/hr")
    public String showPayrollsForEmployee(Model model) {
        Pageable topThree = PageRequest.of(0, 3);
        List<Payroll> lastThreePayrolls = payrollService.PayrollListById3(userContext.getId(), topThree);
        model.addAttribute("payrolls", lastThreePayrolls);
        return "/views/RRHH/RHPanel";
    }

}