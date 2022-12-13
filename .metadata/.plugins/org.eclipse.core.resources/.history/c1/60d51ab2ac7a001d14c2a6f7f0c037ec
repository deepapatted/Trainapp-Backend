package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Booking;

public interface BookingRepository extends MongoRepository<Booking, Long> {

	Booking findByPnr(long pnr);

	List<Booking> findAllByTrainId(String trainId);

	//List<Booking> findTicketsByTrainIdPerDate(String trainId, String date);

	List<Booking> findAllByTrainIdAndDate(String trainId, String date);

}
