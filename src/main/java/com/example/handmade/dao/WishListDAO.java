package com.example.handmade.dao;

import com.example.handmade.models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListDAO extends JpaRepository<WishList, Integer> {
}
