package kk.springframework.springmvc.services;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import kk.springframework.springmvc.config.JpaIntegrationConfig;
import kk.springframework.springmvc.domain.Product;
import lombok.Setter;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { JpaIntegrationConfig.class })
public class ProductServiceJpaDaoImplTest {

    @Setter
    @Autowired
    private ProductService productService;

    @Test
    public void testListAll() {
        List<Product> products = (List<Product>) productService.listAll();
        assert products.size() == 6;
    }
}
