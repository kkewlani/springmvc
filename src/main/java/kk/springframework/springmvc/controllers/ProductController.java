package kk.springframework.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kk.springframework.springmvc.services.ProductService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @RequestMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAllProducts());

        return "products";
    }
}
