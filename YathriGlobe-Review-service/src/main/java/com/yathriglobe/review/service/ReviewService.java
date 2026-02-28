package com.yathriglobe.review.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yathriglobe.review.entity.Review;
import com.yathriglobe.review.repository.ReviewRepository;

@Service
public class ReviewService 
{
	private final ReviewRepository repo;
	
	public ReviewService(ReviewRepository repo) {
        this.repo = repo;
    }

	
	public Review addReview(Review r,String email)
	{
		if(repo.existsByTripIdAndEmail(r.getTripId(), email))
		{
			throw new RuntimeException("You already reviewed this trip");
		}
		
		r.setEmail(email);
		return repo.save(r);
	}
	
	public List<Review> getReviewsByTrip(Long tripId) 
	{
        return repo.findByTripId(tripId);
    }
}
