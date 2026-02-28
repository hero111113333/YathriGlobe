package com.yathriglobe.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yathriglobe.book.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>
{
	List<Booking> findByEmail(String email);
}
