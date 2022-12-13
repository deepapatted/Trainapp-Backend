package com.casestudy.service;

import java.util.List;

import com.casestudy.model.Booking;

public interface BookingService {

	public List<Booking> getAllTickets();

	public Booking reserveTicket(Booking book);

	// enhanced
	public List<Booking> getAllTicketsOfTrain(String trainId);

	public List<Booking> getAllTicketsOfTrainPerDate(String trainId, String date);

	public void cancelTicket(long pnr);

	public void updateSeats(Booking book);

	public void updateMyBookings(Booking book);

	public void cancelMyBookings(long pnr);

	public void cancelSeats(long pnr);

}
