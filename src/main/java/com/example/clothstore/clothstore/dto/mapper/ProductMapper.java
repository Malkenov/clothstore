package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.ProductDto;
import com.example.clothstore.clothstore.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
}

