package kk.springframework.springmvc.domain;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Product {
    private Integer id;
    private String description;
    private BigDecimal price;
    private String imageUrl;
}
