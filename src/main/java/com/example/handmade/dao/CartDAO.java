package com.example.handmade.dao;

import com.example.handmade.models.Cart;
import com.example.handmade.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartDAO extends JpaRepository<Cart, Integer> {
    List<Cart> findAllByClientOrderByCreatedDateDesc(Client client);

    List<Cart> deleteByClient(Client client);
}
