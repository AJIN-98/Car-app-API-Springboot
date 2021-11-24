package com.ust.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class FavouriteVehicle {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int favId;
@NotNull
private int userId;
@NotNull
private int vehicleId;
@NotNull
private String vehicleName;
@NotNull
private String vehicleDetails;
@NotNull
private String vehicleStatus;

public FavouriteVehicle() {
	super();
}

public FavouriteVehicle(int userId, int vehicleId, String vehicleName, String vehicleDetails, String vehicleStatus) {
	super();
	this.userId = userId;
	this.vehicleId = vehicleId;
	this.vehicleName = vehicleName;
	this.vehicleDetails = vehicleDetails;
	this.vehicleStatus = vehicleStatus;
}


public void setFavId(int favId) {
	this.favId = favId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getVehicleId() {
	return vehicleId;
}

public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}

public String getVehicleName() {
	return vehicleName;
}

public void setVehicleName(String vehicleName) {
	this.vehicleName = vehicleName;
}

public String getVehicleDetails() {
	return vehicleDetails;
}

public void setVehicleDetails(String vehicleDetails) {
	this.vehicleDetails = vehicleDetails;
}

public String getVehicleStatus() {
	return vehicleStatus;
}

public void setVehicleStatus(String vehicleStatus) {
	this.vehicleStatus = vehicleStatus;
}

public int getFavId() {
	return favId;
}




}
