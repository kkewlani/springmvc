package kk.springframework.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kk.springframework.springmvc.domain.Product;
import kk.springframework.springmvc.services.ProductService;
import lombok.RequiredArgsConstructor;

@RequestMapping("/product")
@Controller
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @RequestMapping({"/list", "/"})
    public String listProducts(Model model) {
        model.addAttribute("products", productService.listAll());

        return "products";
    }

    @RequestMapping("/{productId}")
    public String getProduct(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getById(productId));
        return "product";
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createOrUpdateProduct(Product product) {
        Product savedOrUpdateProduct = productService.createOrUpdate(product);
        return "redirect:/product/" + savedOrUpdateProduct.getId();
    }

    @RequestMapping("/edit/{productId}")
    public String edit(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getById(productId));
        return "productform";
    }

    @RequestMapping("/delete/{productId}")
    public String delete(@PathVariable Integer productId) {
        productService.delete(productId);
        return "redirect:/products";
    }
}
