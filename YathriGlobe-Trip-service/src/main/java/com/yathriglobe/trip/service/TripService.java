package com.yathriglobe.trip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yathriglobe.trip.client.DestinationClient;
import com.yathriglobe.trip.dto.DestinationResponse;
import com.yathriglobe.trip.entity.Trip;
import com.yathriglobe.trip.repository.TripRepository;

@Service
public class TripService 
{
	private final TripRepository repo;
	private final DestinationClient client;

    public TripService(TripRepository repo,DestinationClient client) 
    {
        this.repo = repo;
        this.client=client;
    }

    public Trip saveTrip(Trip trip) 
    {
    	DestinationResponse destination =client.getDestinationById(trip.getDestinationId());
    	if (destination == null) 
    	{
            throw new RuntimeException("Destination not found");
        }
    	trip.setDestinationName(destination.getName());
    	trip.setPrice(destination.getPrice());
        return repo.save(trip);
    }

    public List<Trip> getTripsByEmail(String email) 
    {
        return repo.findByEmail(email);
    }

    public Trip getTripById(Long id) 
    {
        return repo.findById(id).orElseThrow();
    }

    public void deleteTrip(Long id)
    {
        repo.deleteById(id);
    }
			
}
