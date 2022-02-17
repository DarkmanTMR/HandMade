package com.example.handmade.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartDTO {
    private List<CartProductDTO> cartProducts;
    private double totalCost;
}
