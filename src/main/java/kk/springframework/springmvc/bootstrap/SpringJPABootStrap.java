package kk.springframework.springmvc.bootstrap;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import kk.springframework.springmvc.domain.Product;
import kk.springframework.springmvc.services.ProductService;
import lombok.Setter;

/**
 * This class gets executed when a refresh happens - listening to the context refresh event and thus will load data
 * at the start.
 * This can eb used to load the data at the application start - useful for in-memory DB or even other DBs
 * but if a lot of data is loaded at start up it may slow down the start up process.
 */
@Component
public class SpringJPABootStrap implements ApplicationListener<ContextRefreshedEvent>{

    @Setter
    @Autowired
    private ProductService productService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
    }

    public void loadProducts() {
        Product product1 = new Product("Product1", new BigDecimal("12.99"), "http://example.com/product1");
        productService.createOrUpdate(product1);
        Product product2 = new Product("Product2", new BigDecimal("24.99"), "http://example.com/product2");
        productService.createOrUpdate(product2);
        Product product3 = new Product("Product3", new BigDecimal("76.99"), "http://example.com/product3");
        productService.createOrUpdate(product3);
        Product product4 = new Product("Product4", new BigDecimal("54.99"), "http://example.com/product4");
        productService.createOrUpdate(product4);
        Product product5 = new Product("Product5", new BigDecimal("43.99"), "http://example.com/product5");
        productService.createOrUpdate(product5);
        Product product6 = new Product("Product6", new BigDecimal("23.99"), "http://example.com/product6");
        productService.createOrUpdate(product6);
    }
}
