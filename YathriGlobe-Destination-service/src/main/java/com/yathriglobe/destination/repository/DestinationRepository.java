package com.yathriglobe.destination.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yathriglobe.destination.entity.Destination;

public interface DestinationRepository extends JpaRepository<Destination,Long> 
{
	List<Destination> findByCountry(String country);
}
