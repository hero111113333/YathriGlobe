package com.yathriglobe.book.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yathriglobe.book.entity.Booking;
import com.yathriglobe.book.service.BookingService;
import com.yathriglobe.book.util.JwtUtil;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private static final Logger log =
            LoggerFactory.getLogger(BookingController.class);

    private BookingService service;
    private JwtUtil jwtUtil;

    public BookingController(BookingService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public Booking bookTrip(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, Object> request) {

        log.info("Book trip request received");

        String email = jwtUtil.extractEmail(token.substring(7));
        Long tripId = Long.valueOf(request.get("tripId").toString());
        double amount = Double.parseDouble(request.get("amount").toString());

        log.debug("Booking details: email={}, tripId={}, amount={}",
                email, tripId, amount);

        Booking booking = service.createBooking(tripId, email, amount);

        log.info("Booking created successfully with bookingId={}",
                booking.getId());

        return booking;
    }

    @GetMapping("/get")
    public List<Booking> myBookings(
            @RequestHeader("Authorization") String token) {

        log.info("Get my bookings details request received");

        String email = jwtUtil.extractEmail(token.substring(7));

        log.debug("Fetching bookings for email={}", email);

        List<Booking> bookings = service.getMyBookings(email);

        log.info("Total bookings found for email={} is {}",
                email, bookings.size());

        return bookings;
    }

    @PutMapping("/{id}")
    public Booking cancelBooking(@PathVariable Long id) {

        log.info("Cancel booking request received for bookingId={}", id);

        Booking booking = service.cancelBooking(id);

        log.info("Booking cancelled successfully for bookingId={}", id);

        return booking;
    }
}