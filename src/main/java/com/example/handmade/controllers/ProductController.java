package com.example.handmade.controllers;

import com.example.handmade.dao.ProductDAO;
import com.example.handmade.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@CrossOrigin(origins = {"http://localhost:4200"})

public class ProductController {
    private ProductDAO productDAO;


    @PostMapping
    private Product addProduct(@RequestBody Product product){
        return productDAO.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return productDAO.findById(id).orElse(new Product("nothing here", 0));
    }

    @GetMapping
    public List<Product> allProducts(){
        return productDAO.findAll();
    }

    @PatchMapping("/{id}")
    public Product editProduct(@RequestBody Product productFromRequest){
        Product productFromDB = productDAO.getById(productFromRequest.getId());
        return productDAO.save(productFromDB);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){
        productDAO.deleteById(id);
    }


















}
