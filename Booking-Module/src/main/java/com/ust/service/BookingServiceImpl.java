package com.ust.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Repository.BookingRepository;
import com.ust.model.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	
@Autowired
BookingRepository repo;

	@Override
	public boolean createBooking(Booking booking) {
		try {
			repo.save(booking);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateBooking(Booking booking) {
		try {
			Booking v = repo.getById(booking.getBookingId());
			if(v!=null) {
				v.setCarId(booking.getCarId());
				v.setStatus(booking.getStatus());
				v.setUserId(booking.getUserId());
				repo.save(v);
				return true;
				
			}
			return false;
		} catch (Exception e) {
			return false;
		}
}
	
	@Override
	public boolean deleteBooking(int id) {
		Booking v = repo.getById(id);
		if(v!=null) {
			repo.deleteById(id);
			return true;
		}
		return false;
	}

}
