package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.mapper.request.ProductDto;
import com.example.clothstore.clothstore.dto.mapper.responce.ProductResponseDto;
import com.example.clothstore.clothstore.entity.Product;
import com.example.clothstore.clothstore.repository.ProductRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category.id", source = "categoryId")
    Product toEntity(ProductDto dto);

    @Mapping(target = "categoryId", source = "category.id")
    ProductResponseDto toDto(Product entity);
}


