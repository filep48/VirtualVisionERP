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
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Payroll;
import com.virtualvision.erp.domain.UserContext;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.rrhh.rrhhService;

@Controller
public class rrhhController {
    @Autowired
    private IPayroll payrollService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private UserContext userContext;

    @Autowired
    private rrhhService rrhhService;

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @GetMapping("/hr")
    public String showPayrollsForEmployee(Model model) {
        // List the last 3 payrolls of the employee
        Employee employee = employeeService.findEmployeeId(userContext.getId());
        Pageable topThree = PageRequest.of(0, 3);
        List<Payroll> lastThreePayrolls = payrollService.PayrollListById3(userContext.getId(), topThree);
        model.addAttribute("payrolls", lastThreePayrolls);
        // Percentage of data 
        String Datapercentage = rrhhService.percentageData(employee);
        model.addAttribute("percentage", Datapercentage);
        return "/views/RRHH/RHPanel";
    }

    @GetMapping("/employee/edit")
    public String editPersonalForm(Model model) {
        Employee employee = employeeService.findEmployeeId(userContext.getId());
        model.addAttribute("employee", employee);
        model.addAttribute("editMode", true); // Agregamos "editMode" para el título dinámico
        return "views/employees/addEmployee";
    }

}