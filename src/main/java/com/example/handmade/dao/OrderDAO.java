package com.example.handmade.dao;

import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDAO extends JpaRepository<Order, Integer> {
    List<Order> findAllByClientOrderByCreatedDateDesc(Client client);
}
