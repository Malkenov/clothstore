package com.example.clothstore.clothstore.dto.mapper.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
}
