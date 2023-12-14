package com.virtualvision.erp.controller.productController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.service.product.IProductService;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public String listProducts(Model model) {
        List<Product> products = productService.productList();
        model.addAttribute("products", products);
        return "/views/products/listProducts";
    }
}
