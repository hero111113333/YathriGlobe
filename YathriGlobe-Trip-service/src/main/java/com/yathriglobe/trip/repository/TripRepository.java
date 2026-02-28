package com.yathriglobe.trip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yathriglobe.trip.entity.Trip;

@Repository
public interface TripRepository  extends JpaRepository<Trip,Long>
{
		List<Trip >findByEmail(String email);
}
