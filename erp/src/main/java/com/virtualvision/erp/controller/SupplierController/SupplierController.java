package com.virtualvision.erp.controller.SupplierController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.virtualvision.erp.domain.Supplier;
import com.virtualvision.erp.service.supplier.ISupplierService;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;
    
    @GetMapping("/supplier")
    public String listSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.findAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "/views/suppliers/listSuppliers";
    }

    @GetMapping("/supplier/addSupplier")
    public String addSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        model.addAttribute("editMode", false);
        return "views/suppliers/addSupplier";
    }

    @PostMapping("/supplier/saveSupplier")
    public String saveSupplier(Supplier supplier) {
        supplierService.saveSupplier(supplier);
        return "redirect:/supplier";
    }

    @GetMapping("/supplier/deleteSupplier/{id}")
    public String deleteSupplier(@PathVariable Long id) {
        supplierService.deleteSupplier(id);
        return "redirect:/supplier";
    }

    @GetMapping("/supplier/editSupplier/{id}")
    public String editSupplierForm(@PathVariable Long id, Model model) {
        Supplier supplier = supplierService.findSupplierById(id);
        if (supplier != null) {
            model.addAttribute("supplier", supplier);
            model.addAttribute("editMode", true);
            return "views/suppliers/addSupplier";
        } else {
            // Handle the case where the supplier with the given ID doesn't exist
            return "redirect:/supplier";
        }
    }
}

