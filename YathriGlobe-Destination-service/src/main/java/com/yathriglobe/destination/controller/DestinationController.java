package com.yathriglobe.destination.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yathriglobe.destination.entity.Destination;
import com.yathriglobe.destination.service.DestinationService;

@RestController
@RequestMapping("/destinations")
public class DestinationController 
{
	
	private DestinationService service;
	public DestinationController(DestinationService service) 
	{
        this.service = service;
    }
	
	@PostMapping("/post")
	public ResponseEntity<String> create(@RequestBody Destination d)
	{
		service.createDestination(d);
		return ResponseEntity.ok("Destination Created");
	}
	@GetMapping("/{id}")
    public Destination getById(@PathVariable Long id) {
        return service.getById(id);
    }
	
	@GetMapping("/getAll")
    public List<Destination> getAll() {
        return service.getAll();
    }

    @GetMapping("/getcountry/{country}")
    public List<Destination> getByCountry(@PathVariable String country) 
    {
        return service.getByCountry(country);
    }
}
