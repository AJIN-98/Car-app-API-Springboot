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
import java.util.List;
import com.ust.Service.VehicleService;
import com.ust.model.Vehicle;

@RestController
public class VehicleController {

	@Autowired
	VehicleService service;

	@PostMapping("vehicle/add")
	public ResponseEntity<?> addVehicle(@RequestBody Vehicle vehicle) {
		try {
			service.addVehicle(vehicle);
			return new ResponseEntity<String>("added sucessfully!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to add vehicle", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("vehicle/update")
	public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle) {
		try {
			return new ResponseEntity<Vehicle>(service.updateVehicle(vehicle), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to update vehicle", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("vehicle/delete/{id}")
	public ResponseEntity<?> deleteVehicle(@PathVariable int id) {
		try {
			service.deleteVehicle(id);
			return new ResponseEntity<String>("vehicle with id :" + id + " deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to delete vehicle", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("vehicle/sort/price")
	public ResponseEntity<?> sortByPrice() {
		try {
			return new ResponseEntity<List<Vehicle>>(service.sortByPrice(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("failed to sort vehicle", HttpStatus.CONFLICT);
		}
	}
}
