package com.virtualvision.erp.controller.economyController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EconomyController {
    @GetMapping("/economy")
    public String economyToDo() {
        return "views/economy/economy";
    }
}
