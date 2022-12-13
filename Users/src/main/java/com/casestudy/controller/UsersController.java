package com.casestudy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.exception.UserNotFoundException;
import com.casestudy.model.Booking;
import com.casestudy.model.Users;
import com.casestudy.security.AuthenticationRequest;
import com.casestudy.security.AuthenticationResponse;
import com.casestudy.security.JwtUtil;
import com.casestudy.security.MyUserDetailsService;
import com.casestudy.service.UsersService;

@CrossOrigin(origins ="*")
@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private BCryptPasswordEncoder bCrpytPassword;
	
	private Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@PostMapping("/register")
	public String registerUser(@RequestBody Users user) {
		logger.info("Inside register user of users controller");
		String encodedPassword = bCrpytPassword.encode(user.getPassword());
		logger.info("setting  password");
		user.setPassword(encodedPassword);
		logger.info("Added User");
		return usersService.registerUser(user);		
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
				);
		} catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password",e);
		}
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		String role = userDetails.getAuthorities().toString();
		
		logger.info("Authenticated !!!!");
		return ResponseEntity.ok(new AuthenticationResponse(jwt, role));
		
	}
	@GetMapping("/showProfile")
	public Users showProfile() {
		logger.info("Showing Profiles!!!");
		return usersService.showProfile();
	}
	
	@GetMapping("/getUser/{username}")
	public Users getUser(@PathVariable String username) throws UserNotFoundException {
		logger.info("Getting user by username");
		return usersService.getUser(username);
	}
	
	@GetMapping("/myBookings")
	public List<Booking> showMyBookings(){
		logger.info("Displaying all bookings");
		return usersService.showMyBookings();
		
	}
	
	@PutMapping("/updateUser")
	public void updateUser(@RequestBody Users user) {
		logger.info("Updating User");
		usersService.updateUser(user);
	}
	
	@DeleteMapping("/removeUser/{username}")
	public String removeUser(@PathVariable String username) throws UserNotFoundException {
		logger.info("Removing  User");
		return usersService.removeUser(username);
	}
	
	@GetMapping("/allUsers")
	public List<Users>allUsers(){
		return usersService.allUsers();
	}
}
