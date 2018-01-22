package kk.springframework.springmvc.services;

import java.util.List;

import kk.springframework.springmvc.domain.Product;

public interface ProductService {
    List<Product> listAllProducts();

    Product getProductById(Integer productId);

    Product createOrUpdateProduct(Product product);

    void deleteProduct(Integer productId);
}
