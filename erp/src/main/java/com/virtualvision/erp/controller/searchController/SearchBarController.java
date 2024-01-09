package com.virtualvision.erp.controller.searchController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SearchBarController {
    
    @GetMapping("/searchbar")
    public String getSearch() {
        return "/views/searchbar/searchbar";
    }
    
}
