package com.ust.service;

import com.ust.model.Booking;

public interface BookingService {

	boolean createBooking(int uid,int vid);

	boolean updateBooking(int bookingId, int vid);

	boolean deleteBooking(int id);
	
	Booking getbyuid(int id);
}
