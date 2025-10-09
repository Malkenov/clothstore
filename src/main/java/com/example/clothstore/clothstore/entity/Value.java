package com.example.clothstore.clothstore.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "value")

public class Value {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String value;


    @ManyToOne
    @JoinColumn(name = "option_id")
    private Option option;
}
