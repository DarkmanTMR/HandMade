package com.example.handmade.controllers;

import com.example.handmade.dao.ReviewDAO;
import com.example.handmade.models.Review;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ReviewController {
    private ReviewDAO reviewDAO;


    @PostMapping
    private Review addReview(@RequestBody Review review){
        return reviewDAO.save(review);
    }

    @GetMapping("/{id}")
    public Review getReview(@RequestBody int id){
        return reviewDAO.findById(id).orElse(new Review("empty"));
    }


    @GetMapping
    public List<Review> allReviews(){
        return reviewDAO.findAll();
    }

    @PatchMapping
    public Review editReview(@RequestBody Review reviewFromRequest){
        Review reviewFromDB = reviewDAO.getById(reviewFromRequest.getId());
        return  reviewDAO.save(reviewFromDB);
    }


    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id){
        reviewDAO.deleteById(id);
    }














}
