package com.virtualvision.erp.controller.saleController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("sale", new Sale());
        model.addAttribute("customers", customerService.customersList());
        model.addAttribute("employees", employeeService.employeesList());
        // model.addAttribute("products", productService.findAllProducts()); // Omitido por ahora!!!!!!!!!!!!!
        return "views/sales/addSale";
    }

    @PostMapping("/sale/save")
    public String saveSale(@ModelAttribute("sale") Sale sale) {
        saleService.saveSale(sale);
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
    @GetMapping("/sale/detail/{id}")
    public String viewSaleDetail(@PathVariable Long id, Model model) {
        Sale sale = saleService.findSaleById(id);
        if (sale == null) {
            // la venta no existe
            return "redirect:/sale";
        }
        model.addAttribute("sale", sale);
        return "views/sales/saleDetail";
    }
}
