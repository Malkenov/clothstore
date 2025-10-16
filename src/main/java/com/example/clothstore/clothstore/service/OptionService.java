package com.example.clothstore.clothstore.service;

import com.example.clothstore.clothstore.dto.mapper.OptionMapper;
import com.example.clothstore.clothstore.dto.mapper.request.OptionDto;
import com.example.clothstore.clothstore.dto.mapper.responce.OptionResponseDto;
import com.example.clothstore.clothstore.entity.Option;
import com.example.clothstore.clothstore.entity.Product;
import com.example.clothstore.clothstore.entity.Value;

import com.example.clothstore.clothstore.exception.BadRequestException;
import com.example.clothstore.clothstore.exception.NotFoundException;
import com.example.clothstore.clothstore.repository.OptionRepository;
import com.example.clothstore.clothstore.repository.ProductRepository;
import com.example.clothstore.clothstore.repository.ValueRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionService {

    private final OptionRepository optionRepository;
    private final ProductRepository productRepository;
    private final ValueRepository valueRepository;
    private final OptionMapper optionMapper;


    public Option getById(Long id) {
        return optionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Номер " + id + " не найден!"));
    }

    @Transactional
    public OptionResponseDto addOption(Option option, Long productId, List<Long> value_id) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Продукт с id " + productId + " не найден!"));

        List<Value> values = valueRepository.findAllById(value_id);

        option.setProduct(product);
        option.setValues(values);
        optionRepository.save(option);
        return optionMapper.toDto(option);
    }


    @Transactional
    public void deleteOption(Long id) {
        if (optionRepository.existsById(id)) {
            optionRepository.deleteById(id);
        } else {
            throw new NotFoundException("Нету такой опции");
        }
    }
}
