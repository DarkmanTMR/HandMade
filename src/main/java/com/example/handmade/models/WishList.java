package com.example.handmade.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table(name = "wish_list")
@Entity
@Getter
@Setter
@NoArgsConstructor


public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int ClientId;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> productList;

    public WishList(int id, int clientId) {
        this.id = id;
        ClientId = clientId;
    }
}
