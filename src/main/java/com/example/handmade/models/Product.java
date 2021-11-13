package com.example.handmade.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Table(name = "product")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Picture> pictures; //load file
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviewList;
    private float rate;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
