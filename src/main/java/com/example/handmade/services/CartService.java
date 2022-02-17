package com.example.handmade.services;

import com.example.handmade.dao.CartDAO;
import com.example.handmade.dto.cart.AddToCartDTO;
import com.example.handmade.dto.cart.CartDTO;
import com.example.handmade.dto.cart.CartProductDTO;
import com.example.handmade.exceptions.CartProductNotExistException;
import com.example.handmade.models.Cart;
import com.example.handmade.models.Client;
import com.example.handmade.models.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
@Transactional
    public class CartService {

    private CartDAO cartDAO;


    public void addToCart(AddToCartDTO addToCartDTO, Product product, Client client){
    Cart cart = new Cart(product, client, addToCartDTO.getQuantity());
    cartDAO.save(cart);
}
    public CartDTO listCartProducts(Client client){
        List<Cart> cartList = cartDAO.findAllByClientOrderByCreatedDateDesc(client);
        List<CartProductDTO> cartProducts = new ArrayList<>();
        for (Cart cart: cartList){
            CartProductDTO cartProductDTO = getDTOFromCart(cart);
            cartProducts.add(cartProductDTO);
        }
        double totalCost = 0;
        for (CartProductDTO cartProductDTO : cartProducts){
            totalCost += (cartProductDTO.getProduct().getPrice()* cartProductDTO.getQuantity());
        }
        return new CartDTO(cartProducts, totalCost);
    }

    public static CartProductDTO getDTOFromCart(Cart cart) {
        return new CartProductDTO(cart);
    }

    public void deleteCartProduct(int id, int clientId) throws CartProductNotExistException {
        if(!cartDAO.existsById(id))
            throw new CartProductNotExistException("Cart id is not valid" + id);
        cartDAO.deleteById(id);
    }

    public void deleteCartProducts(int clientId){
        cartDAO.deleteAll();
    }

    public void deleteClientCartProducts(Client client){
        cartDAO.deleteByClient(client);
    }
}
