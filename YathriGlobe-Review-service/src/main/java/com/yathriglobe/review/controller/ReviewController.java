package com.yathriglobe.review.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yathriglobe.review.entity.Review;
import com.yathriglobe.review.service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController 
{
	private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }
    
    @PostMapping
    public Review addReview(
    		 @RequestHeader("X-User-Email") String email,
    		 @RequestBody Review review
            ) 
    {
    	
    	
    	review.setEmail(email);
        return service.addReview(review, email);
    }
    
    @GetMapping("/trip/{tripId}")
    public List<Review> getReviews(@PathVariable Long tripId) 
    {
        return service.getReviewsByTrip(tripId);
    }
}
