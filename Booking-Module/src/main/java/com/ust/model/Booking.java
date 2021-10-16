package com.ust.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Booking {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int bookingId;
@NotNull
private int userId;
@NotNull
private int carId;
@NotNull
private String status;


public Booking(int bookingId, int userId, int carId, String status) {
	super();
	this.bookingId = bookingId;
	this.userId = userId;
	this.carId = carId;
	this.status = status;
}


public int getBookingId() {
	return bookingId;
}


public void setBookingId(int bookingId) {
	this.bookingId = bookingId;
}


public int getUserId() {
	return userId;
}


public void setUserId(int userId) {
	this.userId = userId;
}


public int getCarId() {
	return carId;
}


public void setCarId(int carId) {
	this.carId = carId;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


}
