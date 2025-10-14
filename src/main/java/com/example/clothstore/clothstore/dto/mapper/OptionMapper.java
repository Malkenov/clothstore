package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.OptionDto;
import com.example.clothstore.clothstore.entity.Option;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.ScopeMetadata;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    Option toEntity(OptionDto dto);
    OptionDto toDto(Option entity);
}
