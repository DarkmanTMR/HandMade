package com.example.handmade.dto.cart;

import com.example.handmade.models.Cart;
import com.example.handmade.models.Product;
import com.sun.istack.NotNull;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CartProductDTO {
    private Integer id;
    private @NotNull Integer quantity;
    private @NotNull Product product;

    public CartProductDTO(Cart cart){
        this.setId(cart.getId());
        this.setQuantity(cart.getQuantity());
        this.setProduct(cart.getProduct());
    }

}
