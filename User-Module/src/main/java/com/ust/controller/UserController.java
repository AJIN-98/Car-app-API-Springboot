package com.ust.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Service.UserService;
import com.ust.model.User;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/user/register")
	public ResponseEntity<String> RegisterUser(User user){
		try {
			service.userRegisteration(user);
			return new ResponseEntity<String>("Registered!",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!",HttpStatus.CONFLICT);
		}
	}
	
	@PutMapping("/user/update")
	public ResponseEntity<String> UpdateUser(User user){
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("User Updated!",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to update!",HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/user/addfavourite")
	public ResponseEntity<String> AddtoFavourite(User user){
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("added to favourite!",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to add!",HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/user/removefavourite")
	public ResponseEntity<String> RemoveFavourite(User user){
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("removed from favourite",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to remove!",HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/user/booking")
	public ResponseEntity<String> PlaceOrder(User user){
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("order placed!",HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!",HttpStatus.CONFLICT);
		}
	}
}
