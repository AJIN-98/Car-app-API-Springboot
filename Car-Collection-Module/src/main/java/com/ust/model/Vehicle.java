package com.ust.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Vehicle {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int vehicleId;
@NotNull
private String category;
@NotNull
private String name;
@NotNull
private String model;
@NotNull
private String price;
@NotNull
private String Details;


public Vehicle(int vehicleId, String category, String name, String model, String price, String details) {
	super();
	this.vehicleId = vehicleId;
	this.category = category;
	this.name = name;
	this.model = model;
	this.price = price;
	Details = details;
}


public int getVehicleId() {
	return vehicleId;
}


public void setVehicleId(int vehicleId) {
	this.vehicleId = vehicleId;
}


public String getCategory() {
	return category;
}


public void setCategory(String category) {
	this.category = category;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getModel() {
	return model;
}


public void setModel(String model) {
	this.model = model;
}


public String getPrice() {
	return price;
}


public void setPrice(String price) {
	this.price = price;
}


public String getDetails() {
	return Details;
}


public void setDetails(String details) {
	Details = details;
}



}
