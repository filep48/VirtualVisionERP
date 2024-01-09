package com.virtualvision.erp.controller.rrhhController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Payroll;
import com.virtualvision.erp.domain.UserContext;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.rrhh.IrrhhService;

import jakarta.validation.Valid;

@Controller
public class payrollController {

    @Autowired
    private IrrhhService payrollService;

    public payrollController(IrrhhService payrollService) {
        this.payrollService = payrollService;
    }

    @Autowired
    private UserContext userContext;

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("rrhh/payroll")
    public String listPayrolls(Model model) {
        System.out.println(userContext.getId());
        List<Payroll> payrolls = payrollService.PayrollListById(userContext.getId());
        model.addAttribute("payrolls", payrolls);
        return "views/RRHH/payroll/listPayroll";
    }

    @GetMapping("/rrhh/payroll/add")
    public String addEmployeeForm(Model model) {
        List<Employee> employeeList = employeeService.employeesList();
        model.addAttribute("employees", employeeList);
        model.addAttribute("payroll", new Payroll());
        return "views/RRHH/payroll/addPayroll";
    }

    @PostMapping("/rrhh/payroll/save")
    public String savePayroll(@ModelAttribute("payroll") @Valid Payroll payroll, BindingResult bindingResult,
            Model model) {
        // imprimeme todos los datos de payroll
        System.out.println(payroll.toString());

        payrollService.createPayroll(payroll);
        return "redirect:/rrhh/payroll";
    }

}