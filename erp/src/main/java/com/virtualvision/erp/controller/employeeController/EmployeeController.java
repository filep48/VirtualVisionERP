package com.virtualvision.erp.controller.employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.passwordEnconder.PasswordEnconder;

import jakarta.validation.Valid;

@Controller
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/employee")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.employeesList();
        model.addAttribute("employees", employees);
        return "views/employees/listEmployees";
    }

    @GetMapping("/employee/add")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("editMode", false);
        return "views/employees/addEmployee";
    }

    @PostMapping("/employee/save")
    public String saveEmployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
            return "views/employees/addEmployee";
        }
        employee.setPassword(PasswordEnconder.passwordEncoder().encode(employee.getPassword()));
        employeeService.saveEmployee(employee);

        return "redirect:/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = employeeService.findEmployeeId(id);
        model.addAttribute("employee", employee);
        model.addAttribute("editMode", true); // Agregamos "editMode" para el título dinámico
        return "views/employees/addEmployee";
    }

}
