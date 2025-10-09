package com.example.clothstore.clothstore.service;

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


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Нету данного товара!"));
    }


    @Transactional
    public Product addProduct(Product product, Long category_id) {
        Category category = categoryRepository.findById(category_id)
                .orElseThrow(() -> new NotFoundException("Нету такой категории!"));

        product.setCategory(category);
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Long product_id, Product product, Long category_id) {
        Product p = productRepository.findById(product_id)
                .orElseThrow(() -> new BadRequestException("Нету данного товара!"));
        Category category = categoryRepository.findById(category_id)
                .orElseThrow(() -> new BadRequestException("Категория не найдена!"));

        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setCategory(category);
        return productRepository.save(p);
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
