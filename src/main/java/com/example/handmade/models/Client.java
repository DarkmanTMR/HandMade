package com.example.handmade.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "client")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Client implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id",nullable = false)
    private int id;
    @Column(name = "role")
    private String role = "ROLE_CLIENT";
    @Column(name = "name")
    private String name;
    @Column(name ="lastName")
    private String lastName;
    @Column(name ="birthday")
    private int birthday;
    @Column(name ="gender")
    private Gender gender;
    @Column(name ="country")
    private String country;
    @Column(name ="settlement")
    private String settlement;
    @Column(name ="password")
    private String password;
    @Column(name ="email")
    private String email;
    @Column(name ="status")
    private boolean status;
    @Column(name ="isActivated")
    private boolean isActivated = false;
    @Column(name ="activationToken")
    private String activationToken;
    @Column(name ="authToken")
    private String authToken;
    @Column(name ="loginToken")
    private String loginToken;
        @Transient
        @Column(name ="wishlist")
    private WishList wishlist;
    @Column(name = "reviews")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Review> reviews;
    @Column(name = "orders")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Order> orders;

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Client(String role, String name, String lastName, String password) {
        this.role = role;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority((role)));
        return authorityList;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
