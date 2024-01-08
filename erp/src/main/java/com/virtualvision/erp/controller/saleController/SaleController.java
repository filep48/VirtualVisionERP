package com.virtualvision.erp.controller.saleController;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.virtualvision.erp.domain.CompanyEvent;
import com.virtualvision.erp.domain.Employee;
import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.domain.Sale;
import com.virtualvision.erp.service.ICustomerService;
import com.virtualvision.erp.service.companyEvent.ICompanyEventService;
import com.virtualvision.erp.service.employee.IEmployeeService;
import com.virtualvision.erp.service.product.IProductService;
import com.virtualvision.erp.service.sale.ISaleService;

import jakarta.transaction.Transactional;

@Controller
public class SaleController {

    @Autowired
    private ISaleService saleService;
    @Autowired
    private ICustomerService customerService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICompanyEventService companyEventService;

    @GetMapping("/sale")
    public String listSales(Model model) {
        List<Sale> sales = saleService.findAllSales();
        model.addAttribute("sales", sales);
        return "views/sales/listSales";
    }

    // añadir una nueva venta
    @GetMapping("/sale/add")
    public String addSaleForm(Model model) {
        Sale sale = new Sale();
        Set<Employee> employeesSet = new HashSet<>(employeeService.employeesList());
        sale.setEmployees(employeesSet);

        // Obtener listas de productos y eventos disponibles
        List<Product> availableProducts = productService.findAll();
        List<CompanyEvent> availableEvents = companyEventService.findAllCompanyEvents();

        model.addAttribute("sale", sale);
        model.addAttribute("customers", customerService.customersList());
        model.addAttribute("availableProducts", availableProducts);
        model.addAttribute("availableEvents", availableEvents);
        return "views/sales/addSale";
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

    @PostMapping("/sale/save")
    public String saveSale(@ModelAttribute("sale") Sale sale, RedirectAttributes redirectAttrs) {
        boolean isNewSale = sale.getId() == null;

        // Verifica si la venta es online
        if (sale.isOnlineSale()) {
            sale.setEmployees(null);
        } else if (sale.getEmployeeId() != null) {
            // La venta no es en línea, verifica si se proporciona una ID de empleado
            Employee existingEmployee = employeeService.findEmployeeId(sale.getEmployeeId());
            if (existingEmployee != null) {
                Set<Employee> employees = new HashSet<>();
                employees.add(existingEmployee);
                sale.setEmployees(employees);
            } else {
                // Manejar error si el empleado no existe
                redirectAttrs.addFlashAttribute("errorMessage",
                        "Empleado con ID " + sale.getEmployeeId() + " no existe.");
                return "redirect:/sale/add";
            }
        }

        // Guarda la venta
        saleService.saveSale(sale);

        // Redirecciona según sea una venta nueva o una edición
        if (isNewSale) {
            return "redirect:/sale/addProductsAndEvents/" + sale.getId();
        } else {
            redirectAttrs.addFlashAttribute("successMessage", "Venta actualizada con éxito");
            return "redirect:/sale";
        }
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

    @GetMapping("/sale/detail/{id}")
public String viewSaleDetail(@PathVariable Long id, Model model) {
    Sale sale = saleService.findSaleById(id);
    if (sale == null) {
        // la venta no existe
        return "redirect:/sale";
    }

    // Agrega el nombre del cliente si existe
    if (sale.getCustomer() != null) {
        model.addAttribute("customerName", sale.getCustomer().getName());
    } else {
        // variable `customerName` incluso si no hay cliente
        model.addAttribute("customerName", "");
    }

    // carga la relación con los empleados
    sale.getEmployees().size();

    // Agrega productos y eventos a la vista
    model.addAttribute("products", sale.getProducts());
    model.addAttribute("events", sale.getEvents());

    // verifica si es una venta en online y se lo pasa a la vista
    boolean isOnlineSale = sale.isOnlineSale();
    model.addAttribute("isOnlineSale", isOnlineSale);

    model.addAttribute("sale", sale);

    return "views/sales/saleDetail";
}


    // añadir productos a la venta
    @PostMapping("/sale/{saleId}/addProducts")
    public String addProductsToSale(@PathVariable Long saleId, @RequestParam List<Long> selectedProducts) {
        saleService.addProductsToSale(saleId, selectedProducts);
        return "redirect:/sale/addProductsAndEvents/" + saleId;
    }

    // añadir eventos a la venta
    @PostMapping("/sale/{saleId}/addEvents")
    public String addEventsToSale(@PathVariable Long saleId, @RequestParam List<Long> selectedEvents) {
        saleService.addEventsToSale(saleId, selectedEvents);
        return "redirect:/sale/addProductsAndEvents/" + saleId;
    }

    @GetMapping("/sale/addProductsAndEvents/{saleId}")
    public String addProductsAndEventsToSale(@PathVariable Long saleId, Model model) {
        Sale sale = saleService.findSaleById(saleId);
        if (sale == null) {
            return "redirect:/sale"; // Manejar el caso de que la venta no exista
        }

        // Obtener listas de productos y eventos disponibles
        List<Product> availableProducts = productService.findAll();
        List<CompanyEvent> availableEvents = companyEventService.findAllCompanyEvents();

        model.addAttribute("sale", sale);
        model.addAttribute("availableProducts", availableProducts);
        model.addAttribute("availableEvents", availableEvents);
        return "views/sales/addProductsAndEvents";
    }


    // @GetMapping("/sale/statistics")
    // public String salesStatistics(Model model) {
    //     double averageSaleAmount = saleService.calculateAverageSaleAmount();
    //     Map<String, Integer> productSaleCount = saleService.calculateSalesByProduct();
    
    //     model.addAttribute("averageSaleAmount", averageSaleAmount);
    //     model.addAttribute("productSaleCount", productSaleCount);
    
    //     return "views/sales/statistics"; 
    // }
    // @GetMapping("/relationshipDetails/{id}")
    // public String viewSaleRelationshipDetails(@PathVariable Long id, Model model)
    // {
    // Sale sale = saleService.getSaleWithDetails(id);

    // if (sale == null) {
    // // Redirige a la lista de ventas si la venta específica no se encuentra
    // return "redirect:/sales/list";
    // }

    // // Agrega la venta al modelo para acceder a ella en la vista
    // model.addAttribute("sale", sale);

    // // detalles de los empleados relacionados con la venta
    // if (!sale.getEmployees().isEmpty()) {
    // model.addAttribute("employees", sale.getEmployees());
    // }

    // // información de los productos de la venta
    // if (!sale.getProducts().isEmpty()) {
    // model.addAttribute("products", sale.getProducts());
    // }

    /////////////////////////// no funciona con la vista, no se porque

    // return "views/sales/saleRelationshipDetails";
    // }

    @GetMapping("/saleRelationshipDetails/{id}")
    public String viewSaleRelationshipDetails(@PathVariable Long id, Model model) {
        // Lógica para obtener los detalles de la venta y sus relaciones
        // Agrega los datos necesarios al modelo
        return "views/sales/saleRelationshipDetails";
    }

}
