package com.example.handmade.dto.order;

import com.example.handmade.models.Order;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class OrderDTO {
    private Integer id;
    private @NotNull Integer clientId;

    public OrderDTO(Order order) {
        this.setId(order.getId());
        this.setClientId(order.getClientId());
    }

}
