package com.example.handmade.controllers;

import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = {"http://localhost:4200"})
public class OrderController {
        private OrderService orderService;


        @GetMapping("/{id}")
        public Order getOrder(@PathVariable int id){
                return orderService.getOrder(id);
        }

        @GetMapping("/")
        public List<Order> getAllOrders(@RequestBody Client client){
                return orderService.ordersList(client);
        }

        @PostMapping("/")
        public Order placeOrder(@RequestBody Client client){
              return orderService.placeOrder(client);
        }

        @DeleteMapping("/{id}")
        public void  deleteOrder(@PathVariable int id){
                orderService.deleteOrderById(id);
        }
}
