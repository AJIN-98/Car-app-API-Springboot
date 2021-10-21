package com.ust.model;

public class Temp {
private int userId;
private int vehicleId;



public Temp() {
	super();
}



public Temp(int userId, int vehicleId) {
	super();
	this.userId = userId;
	this.vehicleId = vehicleId;
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

}
