package com.ust.serviceTest;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ust.Exception.UserAlreadyExistsException;
import com.ust.Exception.userNotFoundException;
import com.ust.Repository.FavouriteRepository;
import com.ust.Repository.UserRepository;
import com.ust.Repository.VehicleRepository;
import com.ust.Service.UserServiceImpl;
import com.ust.model.FavouriteVehicle;
import com.ust.model.Temp;
import com.ust.model.User;
import com.ust.model.Vehicle;

public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;

	@Mock
	VehicleRepository vehicleRepository;

	@Mock
	FavouriteRepository fav;

	User user;

	Vehicle vehicle;

	Temp temp;

	FavouriteVehicle favourite;

	@InjectMocks
	UserServiceImpl userService;

	List<User> userList = null;
	Optional<User> options;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		user = new User();
		user.setAddress("abc");
		user.setGmail("abc@gmil.com");
		user.setPassword("pass@123");
		user.setUserId(1);
		user.setUsername("raju");
		userList = new ArrayList<>();
		userList.add(user);

		options = Optional.of(user);

		vehicle = new Vehicle();
		vehicle.setVehicleId(1);
		vehicle.setCategory("SUV");
		vehicle.setDetails("sports");
		vehicle.setModel("2255");
		vehicle.setName("ford");
		vehicle.setPrice("25000000");

		favourite = new FavouriteVehicle();
		favourite.setUserId(1);
		favourite.setVehicleDetails("sports");
		favourite.setVehicleId(1);
		favourite.setVehicleName("ford");
		favourite.setVehicleStatus("active");
		favourite.setFavId(1);

		temp = new Temp();
		temp.setUserId(1);
		temp.setVehicleId(1);

	}

	@Test
	public void registerUserSuccess() throws UserAlreadyExistsException {
		when(userRepository.save((User) any())).thenReturn(user);
		Boolean Saved = userService.userRegisteration(user);
		assertEquals(true, Saved);

	}

	@Test
	public void registerUserFailure() throws UserAlreadyExistsException {
		when(userRepository.save((User) any())).thenReturn(null);
		Boolean Saved = userService.userRegisteration(user);
		assertEquals(true, Saved);

	}

	@Test
	public void updateUser() throws userNotFoundException {
		when(userRepository.findById(user.getUserId())).thenReturn(options);
		user.setAddress("ust");
		Boolean fetchuser = userService.updateUser(user);
		assertEquals(false, fetchuser);

	}

	@Test
	public void addToFavouriteSuccess() throws UserAlreadyExistsException {
		when(vehicleRepository.save((Vehicle) any())).thenReturn(vehicle);
		when(vehicleRepository.getByVehicleId(1)).thenReturn(vehicle);
		when(fav.save((FavouriteVehicle) any())).thenReturn(favourite);
		Boolean Saved = userService.addtoFavourite(temp);
		assertEquals(true, Saved);

	}

	@Test
	public void deleteFavouriteSuccess() throws userNotFoundException {
		when(fav.getByFavId(1)).thenReturn(favourite);
		boolean flag = userService.removeFavourite(1);
		assertEquals(true, flag);

	}

}