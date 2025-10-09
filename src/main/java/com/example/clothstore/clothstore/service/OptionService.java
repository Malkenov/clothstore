package com.example.clothstore.clothstore.service;

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


    public Option getById(Long id) {
        return optionRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Номер " + id + " не найден!"));
    }

    @Transactional
    public Option addOption(Option option, Long product_id, List<Long> value_id) {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new NotFoundException("Продукт с id " + product_id + " не найден!"));

        List<Value> values = valueRepository.findAllById(value_id);

        option.setProduct(product);
        option.setValues(values);


        return optionRepository.save(option);
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
