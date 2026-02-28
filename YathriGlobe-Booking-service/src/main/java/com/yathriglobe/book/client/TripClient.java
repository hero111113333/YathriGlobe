package com.yathriglobe.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="YATHRIGLOBE-TRIP-SERVICE")
public interface TripClient 
{
	 @GetMapping("/trips/{id}")
	Object getTripById(@PathVariable Long id);
}
