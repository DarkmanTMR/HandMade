package com.example.handmade.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "birthday")
    private int birthday;
    @Column(name = "gender")
    private Gender gender;
    @Column(name = "country")
    private String country;
    @Column(name = "settlement")
    private String settlement;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "status")
    private boolean status;
    @Column(name = "isActivated")
    private boolean isActivated = false;
    @Column(name = "activationToken")
    private String activationToken;
    @Column(name = "authToken")
    private String authToken;
    @Column(name = "loginToken")
    private String loginToken;
            @Transient
    private WishList wishlist;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Review> reviews;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order> orders;

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
