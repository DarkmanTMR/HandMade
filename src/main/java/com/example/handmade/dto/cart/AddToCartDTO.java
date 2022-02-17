package com.example.handmade.dto.cart;


import com.sun.istack.NotNull;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddToCartDTO {
    private Integer id;
    private @NotNull Integer productId;
    private  @NotNull Integer quantity;




}
