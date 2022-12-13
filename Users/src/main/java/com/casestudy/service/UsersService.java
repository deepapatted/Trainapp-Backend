package com.casestudy.service;

import java.util.List;
import com.casestudy.exception.UserNotFoundException;
import com.casestudy.model.Booking;
import com.casestudy.model.Users;

//@Service
public interface UsersService {

	public String registerUser(Users user);

	public Users showProfile();

	public Users getUser(String username) throws UserNotFoundException;

	public List<Booking> showMyBookings();

	public void updateUser(Users user);

	// ADMIN FUNCTIONALITY
	public String removeUser(String username) throws UserNotFoundException;

	public List<Users> allUsers();

}
