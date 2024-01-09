package com.virtualvision.erp.controller.shopController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.virtualvision.erp.domain.Cart;
import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.service.product.IProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class storeController {

    private List<Product> products;

    @Autowired
    private IProductService productService;

    @GetMapping("/store")
    public String listProducts(Model model) {
        List<Product> products = productService.productListwithOut0Stock();
        model.addAttribute("products", products);
        return "views/store/store";
    }

    @PostMapping("/store/addToCart")
    public String addToCart(@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity,
            HttpServletRequest request) {
        System.out.println("productId: " + productId);
        System.out.println("quantity: " + quantity);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
        }

        cart.addProduct(productId, quantity);
        session.setAttribute("cart", cart);

        return "redirect:/store";
    }

    @GetMapping("/store/cart")
    public String listProducts(Model model, HttpServletRequest request) {

        model.addAttribute("products", products);

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        model.addAttribute("cart", cart);

        return "views/store/cart";
    }
}
