package com.virtualvision.erp.controller.loginController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtualvision.erp.domain.UserContext;
import com.virtualvision.erp.service.ICustomerService;

@Controller
public class LoginController {

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private UserContext userContext;

    // crea un contructor para inyectar el servicio
    public LoginController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "/views/customers/login";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "/views/dashboard/dashboard";
    }

}
