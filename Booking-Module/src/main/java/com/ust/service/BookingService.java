package com.ust.service;

import com.ust.model.Booking;

public interface BookingService {

	boolean createBooking(Booking booking);
	boolean updateBooking(Booking booking);
	boolean deleteBooking(int id);
}
