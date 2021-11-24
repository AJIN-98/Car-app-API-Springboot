package com.ust.service;

import java.util.List;

import com.ust.model.Booking;

public interface BookingService {

	boolean createBooking(int uid,int vid);

	boolean deleteBooking(int id);
	
	List<Booking> getbyuid(int id);
}
