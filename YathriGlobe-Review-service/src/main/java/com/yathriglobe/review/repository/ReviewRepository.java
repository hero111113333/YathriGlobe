package com.yathriglobe.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yathriglobe.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>
{
	List<Review> findByTripId(Long tripId);
	boolean existsByTripIdAndEmail(Long tripId, String email);
}
