package com.ust.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ust.Exceptions.VehicleNotFoundException;
import com.ust.model.Vehicle;

public interface VehicleService {
	boolean addVehicle(Vehicle vehicle);

	Vehicle updateVehicle(Vehicle vehicle) throws VehicleNotFoundException;

	boolean deleteVehicle(int id);

	List<Vehicle> sortByPrice();
}
