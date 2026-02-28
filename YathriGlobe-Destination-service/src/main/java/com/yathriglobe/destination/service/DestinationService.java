package com.yathriglobe.destination.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yathriglobe.destination.entity.Destination;
import com.yathriglobe.destination.repository.DestinationRepository;

@Service
public class DestinationService 
{
	private DestinationRepository repo;
	
	public DestinationService(DestinationRepository repo)
	{
		this.repo=repo;
	}
	
	public Destination createDestination(Destination d)
	{
		return repo.save(d);
	}
	
	public Destination getById(Long id) {
	    return repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Destination not found"));
	}
	public List<Destination> getAll()
	{
		return repo.findAll();
	}
	
	public List<Destination> getByCountry(String country)
	{
		return repo.findByCountry(country);
	}
}
