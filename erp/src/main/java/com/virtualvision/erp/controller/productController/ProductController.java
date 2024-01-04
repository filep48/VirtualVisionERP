package com.virtualvision.erp.controller.productController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.virtualvision.erp.domain.Product;
import com.virtualvision.erp.domain.Supplier;
import com.virtualvision.erp.service.product.IProductService;
import com.virtualvision.erp.service.supplier.ISupplierService;

import java.util.List;
import org.springframework.ui.Model;

@Controller

public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ISupplierService supplierService;

    @GetMapping("/product")
    public String listProducts(Model model) {
        List<Product> products = productService.productList();
        model.addAttribute("products", products);
        return "/views/products/listProducts";
    }

    @GetMapping("/product/addProduct")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("editMode", false);

        List<Supplier> suppliers = supplierService.findAllSuppliers();
        model.addAttribute("suppliers", suppliers);

        return "views/products/addProduct";
    }

    @PostMapping("/product/saveProduct")
    public String saveProduct(Product product) {
        productService.save(product);
        return product.getId() != null ? "redirect:/product" : "redirect:/product/addProduct";
    }

    @GetMapping("/product/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }

    @GetMapping("/product/editProduct/{id}")
    public String editCustomerForm(@PathVariable Long id, Model model) {
        Product product = productService.findProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("editMode", true);
        return "views/products/addProduct";
    }

    // para buscador
    @GetMapping("/product/searchPage")
    public String searchPage() {
        return "views/products/searchProducts";
    }

    @GetMapping("/product/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        List<Product> searchResults = productService.searchProducts(query);
        model.addAttribute("products", searchResults);
        return "views/products/searchProducts";
    }
    // para selector en ventas
    @GetMapping("/product/select")
    public String selectProducts(Model model) {
        List<Product> products = productService.productList();
        model.addAttribute("products", products);
        return "views/products/selectProducts";
    }
}
