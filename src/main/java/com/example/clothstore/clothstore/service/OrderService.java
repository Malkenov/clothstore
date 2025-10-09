package com.example.clothstore.clothstore.service;

import com.example.clothstore.clothstore.entity.Order;
import com.example.clothstore.clothstore.entity.Product;
import com.example.clothstore.clothstore.entity.User;
import com.example.clothstore.clothstore.enums.OrderStatus;

import com.example.clothstore.clothstore.exception.BadRequestException;
import com.example.clothstore.clothstore.exception.NotFoundException;
import com.example.clothstore.clothstore.repository.OrderRepository;
import com.example.clothstore.clothstore.repository.ProductRepository;
import com.example.clothstore.clothstore.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;


    public Order getById(Long order_id) {
        return orderRepository.findById(order_id)
                .orElseThrow(() -> new NotFoundException("Нету такого заказа"));
    }

    @Transactional
    public Order addOrder(Long user_id, List<Long> products) {
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new BadRequestException("Нету такого пользователя!"));
        List<Product> productList = productRepository.findAllById(products);
        if (productList.isEmpty()) {
            throw new NotFoundException("Список пуст или товары не найдены");
        }
        Order order = new Order();
        order.setProducts(productList);
        order.setOrderDate(LocalDate.now());
        order.setUsers(user);
        order.setStatus(OrderStatus.NEW);
        return orderRepository.save(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new NotFoundException("Нету такого заказа");
        }
    }

}
