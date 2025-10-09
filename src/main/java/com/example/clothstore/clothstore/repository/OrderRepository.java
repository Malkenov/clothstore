package com.example.clothstore.clothstore.repository;

import com.example.clothstore.clothstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
