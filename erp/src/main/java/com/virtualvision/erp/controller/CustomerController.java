package com.virtualvision.erp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.service.ICustomerService;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    // crea un contructor para inyectar el servicio
    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.customersList();
        model.addAttribute("customers", customers);
        model.addAttribute("title", "Lista de clientes");
        return "views/customers/listCustomers";
    }

    @GetMapping("/customer/add")
    public String addCustomerForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "views/customers/addCustomer";
    }

    @PostMapping("/customer/save")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/customer/add";
    }

}
