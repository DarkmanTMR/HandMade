package com.example.handmade.services;

import com.example.handmade.dao.ReviewDAO;
import com.example.handmade.models.Review;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReviewService {
    private ReviewDAO reviewDAO;

    public Review save(Review review) {
        return reviewDAO.save(review);
    }

    public Optional<Review> findById(int id) {
        return reviewDAO.findById(id);
    }

    public List<Review> findAll() {
        return reviewDAO.findAll();
    }

    public void deleteById(int id) {
        reviewDAO.deleteById(id);
    }
}
