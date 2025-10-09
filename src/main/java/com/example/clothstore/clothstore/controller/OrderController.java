package com.example.clothstore.clothstore.controller;

import com.example.clothstore.clothstore.entity.Order;
import com.example.clothstore.clothstore.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/get-id")
    public Order getById(
            @PathVariable Long user_id,
            @RequestBody List<Long> product_id){
        return orderService.addOrder(user_id,product_id);
    }

    @DeleteMapping("/delete-id")
    public void removeOrder(Long order_id){
        orderService.deleteOrder(order_id);
    }
}
