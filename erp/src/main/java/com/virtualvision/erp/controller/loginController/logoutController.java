package com.virtualvision.erp.controller.loginController;

import org.springframework.web.bind.annotation.GetMapping;

public class logoutController {
    
    @GetMapping("/logout")
    public String logoutPage() {
        // This mapping can be used to show a logout success message
        // or perform any post-logout actions you might need
        return "/views/customers/logout"; // This should correspond to a view that confirms successful logout
    }

}
