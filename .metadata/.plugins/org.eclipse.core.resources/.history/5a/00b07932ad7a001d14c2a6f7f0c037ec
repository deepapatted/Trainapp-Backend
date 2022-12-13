package com.casestudy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.casestudy.model.Booking;
import com.casestudy.model.TrainDetails;
import com.casestudy.repository.BookingRepository;
import com.casestudy.service.BookingService;

@SpringBootTest
class BookingApplicationTests {
	
	@Autowired
	private BookingService bookingService;
	@MockBean
	private BookingRepository bookingRepository;

	@Test
	 void getAllTicketsTest() {
		when(bookingRepository.findAll()).thenReturn(Stream
				.of(new Booking(234, "express", "saurabh12", "12345", "2021-04-30", 5, "Delhi", "Kolkata", "General", 5000,1,3,"Saurabh Raut",22,"Male"), new Booking(235, "express", "saurabh123", "12345", "2021-04-30", 2, "Delhi", "Kolkata", "General", 5000,1,3,"Saurabh Raut",22,"Male")).collect(Collectors.toList()));
		assertEquals(2, bookingService.getAllTickets().size());
	}
	
	

}
