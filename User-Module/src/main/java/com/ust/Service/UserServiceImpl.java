package com.ust.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.Exception.userNotFoundException;
import com.ust.Repository.UserRepository;
//import com.ust.model.FavouriteProduct;
import com.ust.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repo;

	@Override
	public boolean userRegisteration(User user) {
		User status=repo.getByUserId(user.getUserId());
		if(status==null) {
			repo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		User status=repo.getByUserId(user.getUserId());
		if(status!=null) {
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
		User c = repo.findByUserNameAndPassword(user.getUsername(), user.getPassword());
		if(c!=null) {
			return true;
		}
		return false;
		}
		catch(Exception e) {
			throw new userNotFoundException("user not found");
	}}

//	@Override
//	public FavouriteProduct addtoFavourite(FavouriteProduct product) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public boolean removeFavourite(FavouriteProduct product) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public boolean placeOrder(int prodid) {
		// TODO Auto-generated method stub
		return false;
	}

}
