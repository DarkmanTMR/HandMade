package com.example.handmade.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @Column(name = "id")
    private int id;
    @Column(name = "ClientID")
    private int ClientID;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Column(name = "productList")
    private List<Product> productList;

    public WishList(int clientID) {
        ClientID = clientID;

    }
}
