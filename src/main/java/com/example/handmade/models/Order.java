package com.example.handmade.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private OrderStatus orderStatus;

    public Order(int id, OrderStatus orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
    }
}
