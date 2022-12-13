package com.casestudy.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Booking;
import com.casestudy.model.TrainDetails;
import com.casestudy.service.BookingService;

@CrossOrigin(origins ="*")
@RestController
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	private Logger logger = LoggerFactory.getLogger(BookingController.class);
	
	@GetMapping("/getAllTickets")
	public List<Booking> getAllTickets() {
		logger.info("Fetching All Tickets");
		return bookingService.getAllTickets();
	}
	//enhanced 
	@GetMapping("/getTicketsByTrain/{trainId}")
	public List<Booking> getAllTicketsOfTrain(@PathVariable String trainId){
		return bookingService.getAllTicketsOfTrain(trainId);
	}
	
	@GetMapping("/checkTickets/{trainId}/{date}")
	public List<Booking> getAllTicketsOfTrainPerDate(@PathVariable("trainId") String trainId, @PathVariable("date") String date){
		logger.info("Fetching Train by source to destintion");
		return bookingService.getAllTicketsOfTrainPerDate(trainId, date);
		
	}

	@PostMapping("/reserve")
	public String reserveTicket(@RequestBody Booking book) {
		bookingService.reserveTicket(book);
		logger.info("Ticket Reserved!!!!");
		return "Ticket Reserved !";

	}
	
	@DeleteMapping("/cancel/{pnr}")
	public String cancelTicket(@PathVariable long pnr) {
		logger.info("Inside Cancel ticket by PNR");
		bookingService.cancelTicket(pnr);
		logger.info("Ticked Cancelled!!!");
		return "Ticket Cancelled !";
	}
}
