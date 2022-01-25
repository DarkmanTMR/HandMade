package com.example.handmade.controllers;

import com.example.handmade.dao.ReviewDAO;
import com.example.handmade.models.Review;
import com.example.handmade.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/reviews")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ReviewController {
    private ReviewDAO reviewDAO;
    private ReviewService reviewService;


    @PostMapping
    private Review addReview(@RequestBody Review review){
        return reviewService.save(review);
    }

    @GetMapping("/{id}")
    public Review getReviewById(@RequestBody int id){
        return reviewService.findById(id).orElse(new Review("empty"));
    }


    @GetMapping
    public List<Review> allReviews(){
        return reviewService.findAll();
    }

    @PatchMapping
    public Review editReview(@RequestBody Review reviewFromRequest){
        Optional<Review> reviewFromDB = reviewService.findById(reviewFromRequest.getId());
        return  reviewService.save(reviewFromRequest);
    }


    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id){
        reviewService.deleteById(id);
    }














}
