package com.example.handmade.services;

import com.example.handmade.dao.ProductDAO;
import com.example.handmade.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductDAO productDAO;


    public Product save(Product product) {
      return productDAO.save(product);
    }

    public Optional<Product> findById(int id) {
        return productDAO.findById(id);
    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public void deleteById(int id) {
         productDAO.deleteById(id);
    }


}
