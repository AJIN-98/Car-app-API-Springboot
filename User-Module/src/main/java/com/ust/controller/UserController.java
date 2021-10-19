package com.ust.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.Exception.userNotFoundException;
import com.ust.Service.UserService;
import com.ust.model.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@PostMapping("/user/register")
	public ResponseEntity<String> RegisterUser(User user) {
		try {
			service.userRegisteration(user);
			return new ResponseEntity<String>("Registered!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed!", HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/user/update")
	public ResponseEntity<String> UpdateUser(User user) {
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("User Updated!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to update!", HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/user/addfavourite")
	public ResponseEntity<String> AddtoFavourite(User user) {
		try {
			service.updateUser(user);
			return new ResponseEntity<String>("added to favourite!", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Failed to add!", HttpStatus.CONFLICT);
		}
	}

	@PostMapping("user/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpSession session) throws userNotFoundException {

		boolean flag = service.validate(user);
		ResponseEntity<String> response;
		if (flag) {
			session.setAttribute("name", user.getUsername());
			String jwtToken = generateToken(user.getPassword());
			response = new ResponseEntity<String>(jwtToken, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@GetMapping("user/logout")
	public ResponseEntity<?> logout(HttpSession session) {
		ResponseEntity<String> response;
		if ((session != null) && (session.getAttribute("name") != null)) {
			session.invalidate(); // destroying the session
			response = new ResponseEntity<String>("Logged Out Successfully", HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Failure", HttpStatus.BAD_REQUEST);
		}
		return response;
	}

//	@PostMapping("/user/removefavourite")
//	public ResponseEntity<String> RemoveFavourite(User user){
//		try {
//			service.updateUser(user);
//			return new ResponseEntity<String>("removed from favourite",HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Failed to remove!",HttpStatus.CONFLICT);
//		}
//	}
//	
//	@PostMapping("/user/booking")
//	public ResponseEntity<String> PlaceOrder(User user){
//		try {
//			service.updateUser(user);
//			return new ResponseEntity<String>("order placed!",HttpStatus.CREATED);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Failed!",HttpStatus.CONFLICT);
//		}
//	}

	private String generateToken(String userName) {
		String token = Jwts.builder().setSubject(userName).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 200000))
				.signWith(SignatureAlgorithm.HS256, "secretKey").compact();
		System.out.println("Token " + token);
		return token;

	}
}
