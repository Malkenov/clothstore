package com.example.clothstore.clothstore.repository;

import com.example.clothstore.clothstore.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
