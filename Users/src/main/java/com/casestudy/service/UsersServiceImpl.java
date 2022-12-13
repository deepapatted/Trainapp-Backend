package com.casestudy.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.casestudy.exception.UserNotFoundException;
import com.casestudy.model.Booking;
import com.casestudy.model.Users;
import com.casestudy.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	private Logger logger = LoggerFactory.getLogger(UsersService.class);
	
	@Override
	public String registerUser(Users user) {		
//	Validation to check if the user is already registered!
		if(usersRepository.existsById(user.getUsername())) {			
			return "Sorry! User is already Registered! Kindly Login!";
		}
		else {
			usersRepository.save(user);
		}
		logger.info("Added User");
		return "User Registered Successfully";			
	}
	
	
	@Override
	public Users showProfile() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		Optional<Users> user = usersRepository.findById(username);
		logger.info("Displaying User profile");
		return user.get();
	}
	

	@Override
	public Users getUser(String username) throws UserNotFoundException{
		if(usersRepository.findById(username).isEmpty()) {
			throw new UserNotFoundException("OOPS! User does not exist!");
		}
		else {
			Optional<Users> userOpt = usersRepository.findById(username);	
			logger.info("Getting User by username");
			return userOpt.get();
		}		
	}

	@Override
	public List<Booking> showMyBookings() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		logger.info("Inside Show my bookings of User");
		String username;
		if (principal instanceof UserDetails) {
		  username = ((UserDetails)principal).getUsername();
		} else {
		  username = principal.toString();
		}
		Optional<Users> userOpt = usersRepository.findById(username);
		Users user = userOpt.get();
		logger.info("My Bookings");
		return user.getBookings();
	}

	@Override
	public void updateUser(Users user) {
		logger.info("Updated User");
		usersRepository.save(user);		
	}

	//ADMIN FUNCTIONALITY
	@Override
	public String removeUser(String username) throws UserNotFoundException {
		//Validation to check if the user exists
		logger.info("Inside remove user of user service");
		if(usersRepository.existsById(username)) {
			usersRepository.deleteById(username);
		}
		else {
			throw new UserNotFoundException("No such user exists !");
		}
		logger.info("User Removed !");
		return "User has been removed!";
	}


	@Override
	public List<Users> allUsers() {
		return usersRepository.findAll();
	}
}
