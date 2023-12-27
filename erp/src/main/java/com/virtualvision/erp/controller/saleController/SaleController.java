package com.virtualvision.erp.controller.saleController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Sale;
import com.virtualvision.erp.service.ICustomerService;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.sale.ISaleService;

@Controller
public class SaleController {

    @Autowired
    private ISaleService saleService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/sale")
    public String listSales(Model model) {
        List<Sale> sales = saleService.findAllSales();
        model.addAttribute("sales", sales);
        return "/views/sales/listSales";
    }

    // controlador que tb sirve para la carga de los selectores
    @GetMapping("/sale/add")
    public String addSaleForm(Model model) {
        Sale sale = new Sale();
        Set<Employee> employeesSet = new HashSet<>(employeeService.employeesList()); // convierte la lista en un
                                                                                     // conjunto
        sale.setEmployees(employeesSet); // relación con los empleados
        model.addAttribute("sale", sale);
        model.addAttribute("customers", customerService.customersList());
        return "views/sales/addSale";
    }

    @PostMapping("/sale/save")
    public String saveSale(@ModelAttribute("sale") Sale sale) {
        // Verifica si la venta es online
        if (sale.isOnlineSale()) {
            // La venta online no requiere un empleado id
            sale.setEmployees(null);
            saleService.saveSale(sale);
            return "redirect:/sale/add";
        }

        // La venta no es en línea, verifica si se proporciona una ID de empleado
        if (sale.getEmployeeId() != null) {
            Employee existingEmployee = employeeService.findEmployeeId(sale.getEmployeeId());
            if (existingEmployee != null) {
                // La ID de empleado existe, asigna el empleado a la venta y guarda la venta
                Set<Employee> employees = new HashSet<>();
                employees.add(existingEmployee);
                sale.setEmployees(employees);
                saleService.saveSale(sale);
                return "redirect:/sale/add";
            } else {
                // model.addAttribute("error", "Empleado con ID " + sale.getEmployeeId() + " no
                // existe.");
                // return "redirect:/sale/add";
            }
        } else {
            // no se proporciona una ID de empleado
            // model.addAttribute("error", "Debes proporcionar una ID de empleado.");
            // return "redirect:/sale/add";
        }
        return "redirect:/sale/add";
    }

    @GetMapping("/sale/delete/{id}")
    public String deleteSale(@PathVariable Long id) {
        saleService.deleteSale(id);
        return "redirect:/sale"; // Redireccionar a la lista de ventas después de eliminar
    }

    @GetMapping("/sale/edit/{id}")
    public String editSaleForm(@PathVariable Long id, Model model) {
        Sale sale = saleService.findSaleById(id);
        model.addAttribute("sale", sale);
        return "views/sales/addSale";
    }

    // controlador para la vista saleDetail
    // @GetMapping("/sale/detail/{id}")
    // public String viewSaleDetail(@PathVariable Long id, Model model) {
    //     Sale sale = saleService.findSaleById(id);
    //     if (sale == null) {
    //         // la venta no existe
    //         return "redirect:/sale";
    //     }
    //     // Agrega el nombre del cliente si existe
    //     if (sale.getCustomer() != null) {
    //         model.addAttribute("customerName", sale.getCustomer().getName());
    //     } else {
    //         // variable `customerName` incluso si no hay cliente
    //         model.addAttribute("customerName", "");
    //     }

    //     // carga la relación con los empleados
    //     sale.getEmployees().size();
    //     model.addAttribute("sale", sale);

    //     // verifica si es una venta en online y se lo pasa a la vista
    //     boolean isOnlineSale = sale.isOnlineSale();
    //     model.addAttribute("isOnlineSale", isOnlineSale);
    //     return "views/sales/saleDetail";
    // }

    // @GetMapping("/relationshipDetails/{id}")
    // public String viewSaleRelationshipDetails(@PathVariable Long id, Model model) {
    //     Sale sale = saleService.getSaleWithDetails(id);


        
        // if (sale == null) {
        //     // Redirige a la lista de ventas si la venta específica no se encuentra
        //     return "redirect:/sales/list";
        // }

        // // Agrega la venta al modelo para acceder a ella en la vista
        // model.addAttribute("sale", sale);

        // //  detalles de los empleados relacionados con la venta
        // if (!sale.getEmployees().isEmpty()) {
        //     model.addAttribute("employees", sale.getEmployees());
        // }

        // //  información de los productos de la venta
        // if (!sale.getProducts().isEmpty()) {
        //     model.addAttribute("products", sale.getProducts());
        // }


        ///////////////////////////no funciona con la vista, no se porque

    //     return "views/sales/saleRelationshipDetails"; 
    // }
}

