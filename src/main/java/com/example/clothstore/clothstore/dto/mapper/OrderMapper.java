package com.example.clothstore.clothstore.dto.mapper;

import com.example.clothstore.clothstore.dto.OrderDto;
import com.example.clothstore.clothstore.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order toEntity(OrderDto dto);
    OrderDto toDto(Order entity);
}
