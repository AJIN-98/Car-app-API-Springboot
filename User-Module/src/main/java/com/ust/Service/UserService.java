package com.ust.Service;

import com.ust.model.FavouriteProduct;
import com.ust.model.User;

public interface UserService {

	public boolean userRegisteration(User user);
	public boolean updateUser(User user);
	public FavouriteProduct addtoFavourite(FavouriteProduct product);
	public boolean removeFavourite(FavouriteProduct product);
	public boolean placeOrder(int prodid);
	
}
