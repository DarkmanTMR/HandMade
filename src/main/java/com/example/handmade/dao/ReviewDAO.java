package com.example.handmade.dao;

import com.example.handmade.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewDAO extends JpaRepository<Review, Integer> {
}
