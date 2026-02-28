package com.yathriglobe.trip.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yathriglobe.trip.entity.Trip;
import com.yathriglobe.trip.service.TripService;
import com.yathriglobe.trip.util.JwtUtil;

@RestController
@RequestMapping("/trips")
public class TripController 
{
	private TripService service;
	private final JwtUtil jwtUtil;
	
	public TripController(TripService service,JwtUtil jwtUtil)
	{
		this.service=service;
		this.jwtUtil=jwtUtil;
	}
	
	
	@PostMapping
	public Trip bookTrip(@RequestHeader("Authorization") String auth,@RequestBody Trip trip)
	{
		String email=jwtUtil.extractEmail(auth.substring(7));
		
		trip.setEmail(email);
		return service.saveTrip(trip);
		
	}
	
	@GetMapping
	public List<Trip> getMyTrips(@RequestHeader("Authorization") String auth)
	{
		String email=jwtUtil.extractEmail(auth.substring(7));
		return service.getTripsByEmail(email);
	}
	
	// GET TRIP BY ID
    @GetMapping("/{id}")
    public Trip getTrip(@PathVariable Long id) 
    {
        return service.getTripById(id);
    }

    // DELETE TRIP
    @DeleteMapping("/{id}")
    public String deleteTrip(@PathVariable Long id) 
    {
        service.deleteTrip(id);
        return "Trip deleted successfully";
    }
}
