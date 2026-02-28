package com.yathriglobe.trip.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.yathriglobe.trip.dto.DestinationResponse;

@FeignClient(name="YathriGlobe-Destination-service")
public interface DestinationClient 
{
	@GetMapping("/destinations/{id}")
    DestinationResponse getDestinationById(@PathVariable Long id);
}
