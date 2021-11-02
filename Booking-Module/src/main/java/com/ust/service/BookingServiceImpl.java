package com.ust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Repository.BookingRepository;
import com.ust.Repository.VehicleRepository;
import com.ust.model.Booking;
import com.ust.model.Vehicle;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository repo;
	
	@Autowired
	VehicleRepository repos;

	@Override
	public boolean createBooking(int uid,int vid) {
		try {
			Vehicle v = repos.getByVehicleId(vid);
			if(v.getVehicleId()==vid) {
			Booking b = new Booking();
			b.setCarId(vid);
			b.setCarDetails(v.getDetails());
			b.setCarName(v.getName());
			b.setStatus("active");
			b.setUserId(uid);
			repo.save(b);
			return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBooking(int bookingId,int vid) {

		Booking b = repo.getByBookingId(bookingId);
		Vehicle v =repos.getByVehicleId(vid);
		if (v != null && b!= null ) {
			b.setCarId(vid);
			b.setCarName(v.getName());
			b.setCarDetails(v.getDetails());
			repo.save(b);
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteBooking(int id) {
		
		Booking v = repo.getByBookingId(id);
		if (v.getBookingId()==id) {
			repo.deleteById(id);
			return true;
		}
			return false;		
	}

	@Override
	public Booking getbyuid(int id) {
		Booking response = repo.getbyUserId(id);
		return response;
	}
	}
