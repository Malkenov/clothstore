package com.example.clothstore.clothstore.service;

import com.example.clothstore.clothstore.entity.Category;
import com.example.clothstore.clothstore.exception.BadRequestException;
import com.example.clothstore.clothstore.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Нету категории под номером " + id));
    }

    @Transactional
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
        } else {
            throw new BadRequestException("Нету такой категории под " + id);
        }
    }
}
