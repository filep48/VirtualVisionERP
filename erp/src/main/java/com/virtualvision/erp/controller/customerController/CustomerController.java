package com.virtualvision.erp.controller.customerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Customer;
import com.virtualvision.erp.service.ICustomerService;
import com.virtualvision.erp.service.passwordEnconder.PasswordEnconder;

import jakarta.validation.Valid;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/customer")
    public String listCustomers(Model model) {
        List<Customer> customers = customerService.customersList();
        model.addAttribute("customers", customers);
        return "/views/customers/listCustomers";
    }

    @GetMapping("/customer/add")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("editMode", false);
        return "views/customers/addCustomer";
    }

    /***
     * llama al metodo updateCustomerWithoutPassword definido en CustomerServiceImp
     * para editar a un cliente sin
     * modificar la contraseña.
     * 
     * @param customer
     * @param bindingResult
     * @return
     */
    @PostMapping("/customer/save")
    public String saveCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult);
            return "views/customers/addCustomer";
        }

        if (customer.getId() != null && (customer.getPassword() == null || customer.getPassword().isEmpty())) {
            // Actualizar cliente sin cambiar la contraseña
            customerService.updateCustomerWithoutPassword(customer);
        } else {
            customer.setPassword(PasswordEnconder.passwordEncoder().encode(customer.getPassword()));
            // Guardar o actualizar cliente (incluyendo contraseña si está presente)
            customerService.saveCustomer(customer);
        }

        return "redirect:/customer";
    }

    @GetMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer"; // Redireccionar a la lista de clientes después de eliminar
    }

    @GetMapping("/customer/edit/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.findCustomerId(id);
        model.addAttribute("customer", customer);
        model.addAttribute("editMode", true);
        return "views/customers/addCustomer";
    }

}
