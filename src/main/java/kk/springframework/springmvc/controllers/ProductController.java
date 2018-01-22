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

    @RequestMapping("/product/{productId}")
    public String getProduct(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping("/product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String createOrUpdateProduct(Product product) {
        Product savedOrUpdateProduct = productService.createOrUpdateProduct(product);
        return "redirect:/product/" + savedOrUpdateProduct.getId();
    }

    @RequestMapping("product/edit/{productId}")
    public String edit(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "productform";
    }

    @RequestMapping("product/delete/{productId}")
    public String delete(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return "redirect:/products";
    }
}
