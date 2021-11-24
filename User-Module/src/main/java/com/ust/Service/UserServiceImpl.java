package com.ust.Service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ust.Exception.userNotFoundException;
import com.ust.Repository.FavouriteRepository;
import com.ust.Repository.UserRepository;
import com.ust.Repository.VehicleRepository;
import com.ust.model.FavouriteVehicle;
import com.ust.model.Temp;
import com.ust.model.User;
import com.ust.model.Vehicle;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository repo;

	@Autowired
	FavouriteRepository favrepo;

	@Autowired
	VehicleRepository vehiclerepo;

	@Override
	public boolean userRegisteration(User user) {
		try {
			repo.save(user);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	@Override
	public boolean updateUser(User user) {
		User status = repo.getByUserId(user.getUserId());
		if (status != null) {
			status.setUsername(user.getUsername());
			status.setPassword(user.getPassword());
			status.setGmail(user.getGmail());
			repo.save(status);
			return true;
		}
		return false;
	}

	public boolean validate(User user) throws userNotFoundException {
		try {
			User c = repo.findByUserIdAndPassword(user.getUserId(), user.getPassword());
			if (c != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new userNotFoundException("user not found");
		}
	}

	@Override
	public boolean addtoFavourite(Temp temp) {
		if (temp != null) {
			Vehicle v = vehiclerepo.getByVehicleId(temp.getVehicleId());
			FavouriteVehicle fav = new FavouriteVehicle();
			fav.setUserId(temp.getUserId());
			fav.setVehicleId(v.getVehicleId());
			fav.setVehicleName(v.getName());
			fav.setVehicleDetails(v.getDetails());
			fav.setVehicleStatus("available");
			favrepo.save(fav);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeFavourite(int id) {
		FavouriteVehicle fav = favrepo.getByFavId(id);
		if (fav.getFavId() == id) {
			favrepo.deleteById(id);
			return true;
		}
		return false;
	}


}
