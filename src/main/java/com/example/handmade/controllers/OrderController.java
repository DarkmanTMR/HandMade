package com.example.handmade.controllers;


import com.example.handmade.dao.OrderDAO;
import com.example.handmade.models.Order;
import com.example.handmade.models.OrderStatus;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {
    private OrderDAO orderDAO;

    @PostMapping
    private Order addOrder(@RequestBody Order order){
        return orderDAO.save(order);
    }

    @GetMapping("/id")
    public Order getOrder(@PathVariable int id){
        return orderDAO.findById(id).orElse(new Order(id,OrderStatus.NotExist));
    }

    @GetMapping
    public List<Order> allOrders(){
        return orderDAO.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        orderDAO.deleteById(id);
    }

    @PatchMapping
    public Order editOrder(@RequestBody Order orderFromRequest){
        Order orderFromDB = orderDAO.getById(orderFromRequest.getId());
        return orderDAO.save(orderFromDB);
    }

}
