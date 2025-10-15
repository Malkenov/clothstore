package com.example.clothstore.clothstore.dto.mapper.responce;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderResponseDto {

        private LocalDate orderDate;
        private Long userId;


    }
