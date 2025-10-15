package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.mapper.request.CategoryDto;
import com.example.clothstore.clothstore.dto.mapper.responce.CategoryResponseDto;
import com.example.clothstore.clothstore.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto dto);
    CategoryResponseDto toDto(Category entity);
}
