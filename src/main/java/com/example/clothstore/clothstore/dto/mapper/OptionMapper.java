package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.mapper.request.OptionDto;
import com.example.clothstore.clothstore.dto.mapper.responce.OptionResponseDto;
import com.example.clothstore.clothstore.entity.Option;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    Option toEntity(OptionDto dto);
    OptionResponseDto toDto(Option entity);
}
