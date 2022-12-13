package com.casestudy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.TrainDetails;

public interface TrainRepository extends MongoRepository<TrainDetails, String>{

	List<TrainDetails> findAllByName(String name);

	List<TrainDetails> findAllBySourceAndDestination(String source, String destination);
	
	
}
