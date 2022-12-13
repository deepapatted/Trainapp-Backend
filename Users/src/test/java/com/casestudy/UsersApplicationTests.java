package com.casestudy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.casestudy.exception.UserNotFoundException;
import com.casestudy.model.Booking;
import com.casestudy.model.Users;
import com.casestudy.repository.UsersRepository;
import com.casestudy.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsersApplicationTests {
	
	@Autowired
	private UsersService usersService;
	@MockBean
	private UsersRepository usersRepository;
	
	@Test
	void registerUserTest() {
		Users user = new Users("saurabh", "Saurabh S Raut", 21, "male", "saurabh8@gmail.com", "password", 9876543213L, "ROLE_USER", new ArrayList<Booking>());
		assertEquals("User Registered Successfully", usersService.registerUser(user));
	}
	
	@Test
	void getUserTest() throws UserNotFoundException {
		String username = "saurabh8";
		Optional<Users> userOpt = Optional.of(new Users("saurabh8", "Saurabh S Raut", 21, "male", "saurabh8@gmail.com", "password", 9876543213L, "ROLE_USER", new ArrayList<Booking>()));
		when(usersRepository.findById(username))
		.thenReturn(userOpt);
		Users user = userOpt.get();
		assertEquals(user, usersService.getUser(username));
	}
	
	@Test
	void removeUserTest() throws UserNotFoundException {
		String username="abc";
		Optional<Users> userOpt = Optional.of(new Users("saurabh", "Saurabh S Raut", 21, "male", "saurabh8@gmail.com", "password", 9876543213L, "ROLE_USER", new ArrayList<Booking>()));
		Users user1 = userOpt.get();
		when(usersRepository.save(user1)).thenReturn(user1);
		when(usersRepository.findById(username))
		.thenReturn(userOpt);
		if(usersRepository.existsById(username)) {
			usersService.removeUser(username);
			verify(usersRepository, times(1)).deleteById(username);
		}
		
	}
	
	

}
