package com.example.handmade.services;

import com.example.handmade.dao.OrderProductsDAO;
import com.example.handmade.models.OrderProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderProductsService {
    private OrderProductsDAO orderProductsDAO;

    public void addOrderedProducts(OrderProduct orderProduct){
        orderProductsDAO.save(orderProduct);
    }
}
