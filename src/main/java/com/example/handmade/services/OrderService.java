package com.example.handmade.services;

import com.example.handmade.dao.OrderDAO;
import com.example.handmade.models.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderDAO orderDAO;


    public Order save(Order order) {
        return orderDAO.save(order);
    }

    public Optional<Order> findById(int id) {
        Optional<Order> order = orderDAO.findById(id);
        if(!order.isPresent()){
            throw new NullPointerException("---------no orders available-----------");
        }
        return order;
    }

    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    public void deleteById(int id) {
        orderDAO.deleteById(id);
    }
}
