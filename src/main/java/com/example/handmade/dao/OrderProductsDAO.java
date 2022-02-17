package com.example.handmade.dao;


import com.example.handmade.models.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsDAO extends JpaRepository<OrderProduct, Integer> {
    }
