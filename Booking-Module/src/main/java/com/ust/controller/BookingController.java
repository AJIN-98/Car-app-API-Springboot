package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.model.Booking;
import com.ust.service.BookingService;

import io.swagger.annotations.Api;

@Api
@RestController
public class BookingController {

	@Autowired
	BookingService service;

	@PostMapping("booking/init/userid/{uid}/vehicleid/{vid}")
	public ResponseEntity<?> initbooking(@PathVariable int uid,@PathVariable int vid) {

		try {
			service.createBooking(uid,vid);
			return new ResponseEntity<String>("order placed!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("booking failed", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("booking/update/bookingid/{bid}/vehicled/{vid}")
	public ResponseEntity<?> updateBooking(@PathVariable int bid, @PathVariable int vid) {
		try {
			service.updateBooking(bid,vid);
			return new ResponseEntity<String>("booking updated", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("can't update right now !", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("booking/{bookingId}")
	public ResponseEntity<?> getbyid(@PathVariable int bookingId){
		try {
			Booking b = service.getbyuid(bookingId);
			if(b!=null) {
			return new ResponseEntity<Booking>(b,HttpStatus.OK);
			}
			return new ResponseEntity<String>("booking not found !",HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<String>("booking not found !",HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("booking/cancel/{id}")
	public ResponseEntity<?> ordercancel(@PathVariable int id) {
		try {
			service.deleteBooking(id);
			return new ResponseEntity<String>("order cancelled", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("error!", HttpStatus.BAD_REQUEST);
		}
	}
}
