package com.example.handmade.controllers;

import com.example.handmade.dao.ProductDAO;
import com.example.handmade.models.Product;
import com.example.handmade.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ProductController {
    private ProductDAO productDAO;
    private ProductService productService;


    @PostMapping
    private Product addProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productService.findById(id).orElse(new Product("nothing here", 0));
    }

    @GetMapping
    public List<Product> allProducts(){
        return productService.findAll();
    }

    @PatchMapping
    public Product editProduct(@RequestBody Product product){
        Optional<Product> productFromDB = productService.findById(product.getProductId());
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteById(id);
    }


















}
