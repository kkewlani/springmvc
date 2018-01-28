package kk.springframework.springmvc.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;
    
    private String description;

    private BigDecimal price;

    private String imageUrl;

    public Product(String description, BigDecimal price, String imageUrl) {
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
