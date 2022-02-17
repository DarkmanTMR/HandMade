package com.example.handmade.controllers;

import com.example.handmade.services.CartService;
import com.example.handmade.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private ProductService productService;
    private CartService cartService;

    /*  in progress */
}
