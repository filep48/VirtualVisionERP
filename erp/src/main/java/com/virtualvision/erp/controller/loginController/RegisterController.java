package com.virtualvision.erp.controller.loginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.service.ICustomerService;
import com.virtualvision.erp.service.passwordEnconder.PasswordEnconder;

@Controller
public class RegisterController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/views/customers/register";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("customer") Customer customer) {
        System.out.println("///////////////////////////////////Customer: " + customer.getUsername());

        // Codifica la contraseña antes de guardarla en la base de datos
        customer.setPassword(PasswordEnconder.passwordEncoder().encode(customer.getPassword()));

        customerService.saveCustomerLogin(customer.getUsername(), customer.getName(), customer.getPassword(),
                customer.getEmail());
        return "redirect:/login";
    }

}
