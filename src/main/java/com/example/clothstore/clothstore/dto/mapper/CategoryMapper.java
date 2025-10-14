package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.CategoryDto;
import com.example.clothstore.clothstore.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toEntity(CategoryDto dto);
    CategoryDto toDto(Category entity);
}
