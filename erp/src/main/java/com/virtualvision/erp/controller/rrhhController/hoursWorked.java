package com.virtualvision.erp.controller.rrhhController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.UserContext;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.rrhh.HoursService;

@Controller
public class hoursWorked {

    @Autowired
    private HoursService hoursService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private UserContext userContext;

    public hoursWorked(HoursService hoursService) {
        this.hoursService = hoursService;
    }

    @GetMapping("/rrhh/workedHours")
    public String getHours(Model model) {
        Employee employee = employeeService.findEmployeeId(userContext.getId());
        model.addAttribute("totalHours", hoursService.getTotalHours(employee));
        return "/views/RRHH/hoursWorked/HoursWorked";
    }

    @PostMapping("/rrhh/workedHours/addHours")
    public String addHours(@RequestParam(name = "hours") Double hours, Model model) {
        Employee employee = employeeService.findEmployeeId(userContext.getId());
        hoursService.addDailyHours(hours, employee);
        return "redirect:/rrhh/workedHours";
    }
}
