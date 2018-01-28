package kk.springframework.springmvc.services;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import kk.springframework.springmvc.domain.DomainObject;
import kk.springframework.springmvc.domain.Product;
import lombok.NonNull;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractDomainMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public void delete(Integer productId) {
        super.delete(productId);
    }

    @Override
    public Product createOrUpdate(@NonNull Product product) {
        return (Product) super.createOrUpdate(product);
    }

    @Override
    public Product getById(Integer productId) {
        return (Product) super.getById(productId);
    }

    @Override
    protected void loadDomainObjectsMap() {
        domainObjectsMap = new HashMap<>();
        Product product1 = new Product("Product1", new BigDecimal("12.99"), "http://example.com/product1");
        domainObjectsMap.put(1, product1);
        Product product2 = new Product("Product2", new BigDecimal("24.99"), "http://example.com/product2");
        domainObjectsMap.put(2, product2);
        Product product3 = new Product("Product3", new BigDecimal("76.99"), "http://example.com/product3");
        domainObjectsMap.put(3, product3);
        Product product4 = new Product("Product4", new BigDecimal("54.99"), "http://example.com/product4");
        domainObjectsMap.put(4, product4);
        Product product5 = new Product("Product5", new BigDecimal("43.99"), "http://example.com/product5");
        domainObjectsMap.put(5, product5);
        Product product6 = new Product("Product6", new BigDecimal("23.99"), "http://example.com/product6");
        domainObjectsMap.put(6, product6);
    }

}
