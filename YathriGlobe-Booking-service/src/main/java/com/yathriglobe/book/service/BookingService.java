package com.yathriglobe.book.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yathriglobe.book.client.TripClient;
import com.yathriglobe.book.entity.Booking;
import com.yathriglobe.book.repository.BookingRepository;

@Service
public class BookingService 
{
	private final BookingRepository repo;
	private final TripClient client;
	
	public BookingService(BookingRepository repo,TripClient client)
	{
		this.client=client;
		this.repo=repo;
	}
	
	public Booking createBooking(Long tripId, String email, double amount)
	{
		client.getTripById(tripId);
		
		Booking b=new Booking();
		b.setTripId(tripId);
		b.setEmail(email);
		b.setAmount(amount);
		b.setStatus("Confirmed");
		b.setBookingDate(LocalDate.now());
		
		return repo.save(b);
		
	}
	
	public List<Booking> getMyBookings(String email)
	{
		return repo.findByEmail(email);
	}
	
	
	public Booking cancelBooking(Long id)
	{
		Booking booking=repo.findById(id).orElseThrow(()->new RuntimeException("Booking Not Found!.."));
		booking .setStatus("Cancelled!!!!");
		return repo.save(booking);
	}
}
