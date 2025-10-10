package com.example.clothstore.clothstore.entity;

import com.example.clothstore.clothstore.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate orderDate;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.NEW;
}
