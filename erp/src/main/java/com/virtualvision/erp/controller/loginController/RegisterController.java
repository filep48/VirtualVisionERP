package com.virtualvision.erp.controller.loginController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register() {
        return "/views/customers/register";
    }

}
