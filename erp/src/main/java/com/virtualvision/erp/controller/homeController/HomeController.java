package com.virtualvision.erp.controller.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String showLoginForm() {
        return "/views/customers/home";
    }

}
