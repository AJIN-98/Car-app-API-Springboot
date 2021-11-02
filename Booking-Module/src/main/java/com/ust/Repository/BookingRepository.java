package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	Booking getByBookingId(int id);

	Booking getbyUserId(int id);
}
