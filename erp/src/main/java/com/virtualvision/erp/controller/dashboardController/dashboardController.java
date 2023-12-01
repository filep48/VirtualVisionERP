package com.virtualvision.erp.controller.dashboardController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class dashboardController {
    
    @GetMapping("/dashboard")
    public String dashboard(){
        return "/views/dashboard/dashboard";
    }

}
