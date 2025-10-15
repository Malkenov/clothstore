package com.example.clothstore.clothstore.dto.mapper.responce;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {

    private String name;
    private String description;
    private BigDecimal price;
    private Long categoryId;
}
