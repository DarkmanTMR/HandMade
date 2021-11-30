package com.example.handmade.models;

import lombok.*;


import javax.persistence.*;

@Table(name = "client_orders")
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Column(name="orders_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "client_id")
    private Integer clientId;
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    public Order(int id, int clientId, OrderStatus orderStatus) {
        this.id = id;
        this.clientId = clientId;
        this.orderStatus = orderStatus;
    }
}
