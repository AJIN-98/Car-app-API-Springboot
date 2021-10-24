package com.ust.Service;

import com.ust.Exception.userNotFoundException;
import com.ust.model.Temp;
//import com.ust.model.FavouriteProduct;
import com.ust.model.User;

public interface UserService {

	public boolean userRegisteration(User user);

	public boolean updateUser(User user);

	public boolean addtoFavourite(Temp temp);

	public boolean removeFavourite(int id);

	public boolean placeOrder(int prodid);

	public boolean validate(User user) throws userNotFoundException;

	boolean cancelOrder(int favId);

}
