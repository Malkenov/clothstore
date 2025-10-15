package com.example.clothstore.clothstore.service;

import com.example.clothstore.clothstore.dto.mapper.ProductMapper;
import com.example.clothstore.clothstore.dto.mapper.request.ProductDto;
import com.example.clothstore.clothstore.dto.mapper.responce.ProductResponseDto;
import com.example.clothstore.clothstore.entity.Category;
import com.example.clothstore.clothstore.entity.Product;

import com.example.clothstore.clothstore.exception.BadRequestException;
import com.example.clothstore.clothstore.exception.NotFoundException;
import com.example.clothstore.clothstore.repository.CategoryRepository;
import com.example.clothstore.clothstore.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;


    public List<ProductResponseDto> getAllProducts() {
       List<Product> products = productRepository.findAll();
       return products.stream()
               .map(productMapper::toDto)
               .toList();
    }

    public ProductResponseDto getById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new BadRequestException("Нету данного товара!"));
        return productMapper.toDto(product);
    }


    @Transactional
    public ProductResponseDto addProduct(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Нету такой категории!"));

        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
        return productMapper.toDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long product_id, ProductDto productDto, Long categoryId) {
        Product product = productRepository.findById(product_id)
                .orElseThrow(() -> new BadRequestException("Нету данного товара!"));
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new BadRequestException("Категория не найдена!"));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return productMapper.toDto(product);

    }

    @Transactional
    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new NotFoundException("Нету данного товара!");
        }
    }
}
