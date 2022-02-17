package com.example.handmade.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orderProduct")

public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderProductId;

    @Column(name = "productId")
    private @NotNull Integer productId;

    @Column(name = "quantity")
    private @NotNull int quantity;

    @Column(name = "price")
    private  @NotNull double price;

    @Column(name = "order_id")
    private Integer orderId;

    @Column (name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;

    @OneToOne
    @JoinColumn(name = "productId", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    public OrderProduct(Integer productId, int quantity, double price, Integer orderId, Date createdDate) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.orderId = orderId;
        this.createdDate = new Date();
    }


}
