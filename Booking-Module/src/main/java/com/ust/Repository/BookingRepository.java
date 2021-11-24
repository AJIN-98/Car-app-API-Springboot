package com.ust.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
	Booking getByBookingId(int id);

	List<Booking> getByUserId(int id);
}
