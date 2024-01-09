package com.virtualvision.erp.controller.shopController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.service.product.IProductService;

@Controller
public class storeController {

    @Autowired
    private IProductService productService;

    @GetMapping("/store")
    public String listProducts(Model model) {
        List<Product> products = productService.productListwithOut0Stock();
        model.addAttribute("products", products);
        return "/views/store/store";
    }
}
