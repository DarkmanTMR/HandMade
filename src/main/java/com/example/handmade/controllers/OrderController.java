package com.example.handmade.controllers;


import com.example.handmade.dao.OrderDAO;
import com.example.handmade.models.Order;
import com.example.handmade.models.OrderStatus;
import com.example.handmade.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {
    private OrderDAO orderDAO;
    private OrderService orderService;

    @PostMapping
    private Order addOrder(@RequestBody Order order){
        return orderService.save(order);
    }

    @GetMapping("/id")
    public Order getOrder(@PathVariable int id){
        return orderService.findById(id).orElse(new Order(100500,100500,OrderStatus.NotExist));
    }

    @GetMapping
    public List<Order> allOrders(){
        return orderService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteById(id);
    }

    @PatchMapping
    public Order editOrder(@RequestBody Order orderFromRequest){
        Optional<Order> orderFromDB = orderService.findById(orderFromRequest.getId());
        return orderService.save(orderFromRequest);
    }

}
