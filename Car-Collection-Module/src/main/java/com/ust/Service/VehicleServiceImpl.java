package com.ust.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Exceptions.VehicleNotFoundException;
import com.ust.model.Vehicle;
import com.ust.repository.VehicleRepository;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository repo;

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		try {
			repo.save(vehicle);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) throws VehicleNotFoundException {

		Vehicle v = repo.getByVehicleId(vehicle.getVehicleId());
		if (v != null) {
			v.setName(vehicle.getName());
			v.setCategory(vehicle.getCategory());
			v.setModel(vehicle.getModel());
			v.setPrice(vehicle.getPrice());
			v.setDetails(vehicle.getDetails());
			repo.save(v);
			return v;

		}
		throw new VehicleNotFoundException("vehicle not found");
	}

	@Override
	public boolean deleteVehicle(int id) {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Vehicle> sortByPrice() {
		List<Vehicle> list = repo.findAll();
		list = list.stream().sorted(Comparator.comparing(Vehicle::getPrice)).collect(Collectors.toList());
		return list;
	}

}
