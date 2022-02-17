package com.example.handmade.services;

import com.example.handmade.dao.OrderDAO;
import com.example.handmade.dao.OrderProductsDAO;
import com.example.handmade.dto.cart.CartDTO;
import com.example.handmade.dto.cart.CartProductDTO;
import com.example.handmade.exceptions.OrderNotFoundException;
import com.example.handmade.models.Client;
import com.example.handmade.models.Order;
import com.example.handmade.models.OrderProduct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderService {
    private OrderDAO orderDAO;
    private CartService cartService;
    private OrderProductsDAO orderProductsDAO;
    private OrderProductsService orderProductsService;

    public Order placeOrder(Client client){
        CartDTO cartDTO = cartService.listCartProducts(client);

        List<CartProductDTO> cartProductDTOList = cartDTO.getCartProducts();

        Order newOrder = new Order();
        newOrder.setCreatedDate(new Date());
        newOrder.setClient(client);
        newOrder.setTotalPrice(cartDTO.getTotalCost());
        orderDAO.save(newOrder);

        for (CartProductDTO cartProductDTO : cartProductDTOList){
            OrderProduct orderItem = new OrderProduct();
                  orderItem.setCreatedDate(new Date());
                  orderItem.setPrice(cartProductDTO.getProduct().getPrice());
                  orderItem.setProduct(cartProductDTO.getProduct());
                  orderItem.setQuantity(cartProductDTO.getQuantity());
                  orderItem.setOrder(newOrder);
                  orderProductsDAO.save(orderItem);
        }
        cartService.deleteClientCartProducts(client);
        return newOrder;
    }

    public List<Order> ordersList(Client client){
        return orderDAO.findAllByClientOrderByCreatedDateDesc(client);
    }

    public Order getOrder(Integer orderId) throws OrderNotFoundException {
        Optional<Order> order = orderDAO.findById(orderId);
        if (order.isPresent()){
            return order.get();
        }
        throw new OrderNotFoundException("Order not found");
    }

    public void deleteOrderById(int id){
        orderDAO.deleteById(id);
    }
}
