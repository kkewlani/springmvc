package kk.springframework.springmvc.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kk.springframework.springmvc.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {

    private Map<Integer, Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    public void loadProducts() {
        products = new HashMap<>();
        Product product1 = new Product(1, "Product1", new BigDecimal("12.99"), "http://example.com/product1");
        products.put(1,product1);
        Product product2 = new Product(2, "Product2", new BigDecimal("24.99"), "http://example.com/product2");
        products.put(2,product2);
        Product product3 = new Product(3, "Product3", new BigDecimal("76.99"), "http://example.com/product3");
        products.put(3,product3);
        Product product4 = new Product(4, "Product4", new BigDecimal("54.99"), "http://example.com/product4");
        products.put(4,product4);
        Product product5 = new Product(5, "Product5", new BigDecimal("43.99"), "http://example.com/product5");
        products.put(5,product5);
        Product product6 = new Product(6, "Product6", new BigDecimal("23.99"), "http://example.com/product6");
        products.put(6,product6);
    }

}
