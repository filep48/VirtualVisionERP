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
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        model.addAttribute("pageTitle", "Agregar Cliente");
        return "/views/customers/addCustomer";
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
    public String saveCustomer(@ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // Manejo de errores de validación
            return "views/customers/addCustomer";
        }

        if (customer.getId() != null && (customer.getPassword() == null || customer.getPassword().isEmpty())) {
            // Actualizar cliente sin cambiar la contraseña
            customerService.updateCustomerWithoutPassword(customer);
        } else {
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
        model.addAttribute("pageTitle", "Editar Cliente");
        return "views/customers/addCustomer";
    }

}
