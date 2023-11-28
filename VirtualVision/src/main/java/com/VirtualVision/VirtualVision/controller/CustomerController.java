package com.VirtualVision.VirtualVision.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import com.VirtualVision.VirtualVision.domain.Customer;
import com.VirtualVision.VirtualVision.service.ICustomerService;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.customersList();
        model.addAttribute("customers", customers);
        return "views/customers/listCustomers";
    }

    
}
