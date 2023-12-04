package com.virtualvision.erp.controller.loginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.service.ICustomerService;

@Controller
public class RegisterController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());

        return "/views/customers/register"; // Asegúrate de que esta ruta sea correcta
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("customer") Customer customer, Model model) {
        boolean isRegistered = customerService.saveCustomerLogin(customer);
        System.out.println("isRegistered: " + isRegistered + " /////////////////////////////////////////");
        if (!isRegistered) {
            model.addAttribute("error", true);
            return "redirect:/register"; // Asegúrate de que esta ruta sea correcta
        }
        return "redirect:/login"; // Redirecciona a la página de inicio de sesión tras un registro exitoso
    }
}