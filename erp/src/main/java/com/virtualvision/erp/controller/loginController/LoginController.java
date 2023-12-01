package com.virtualvision.erp.controller.loginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.service.ICustomerService;

@Controller
public class LoginController {

    @Autowired
    private ICustomerService customerService;

    // crea un contructor para inyectar el servicio
    public LoginController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    /*
     * @AuthenticationPrincipal retorna l'usuari autenticat actualment com un
     * objecte User de Spring security
     */
    @GetMapping("/login")
    public String login(Model model) {
        return "/views/customers/login";
    }

    // redirect from index to /views/customers/customer
    @GetMapping("/")
    public String redirectToCustomer(Model model) {
        return "redirect:/customer";
    }

}
