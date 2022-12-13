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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.TrainDetails;
import com.casestudy.service.TrainService;

@RestController
@CrossOrigin(origins = "*")
public class TrainController {

	@Autowired
	private TrainService trainService;
	
	private Logger logger = LoggerFactory.getLogger(TrainController.class);
	
	@GetMapping("/trainDetails")
	public List<TrainDetails> getAllTrains(){
		logger.info("Fetching All Trains");
		return trainService.getAllTrains();
	}
	
	@GetMapping("/trainSearchByName/{search}")
	public List<TrainDetails> getTrainByName(@PathVariable String search){
		logger.info("Fetching Train by Name");
		return trainService.getTrainByName(search);
	}
	
	@GetMapping("/trainSearchById/{search}")
	public TrainDetails getTrainById(@PathVariable String search) {
		logger.info("Fetching Train By Id");
		return trainService.getTrainById(search);
	}
	
	@PostMapping("/addTrains")
	public String addTrains(@RequestBody TrainDetails trainDetails) {
		logger.info("Adding Train");
		trainService.addTrains(trainDetails);
		logger.info("Train Added!!");
		return "Train Added Successfully ! ";
	}
	

	
	@GetMapping("/checkTrains/{source}/{destination}")
	public List<TrainDetails> checkTrains(@PathVariable("source") String source, @PathVariable("destination") String destination){
		logger.info("Fetching Train by source to destintion");
		return trainService.checkTrains(source, destination);
		
	}
	
	@PutMapping("/updateTrain")
	public void updateTrain(@RequestBody TrainDetails trainDetails) {
		logger.info("Train updated");
		trainService.updateTrain(trainDetails);
	}
	
	@DeleteMapping("/removeTrain/{trainId}")
	public String removeTrain(@PathVariable String trainId) {
		logger.info("Train Deleted!!!");
		return trainService.removeTrain(trainId);
	}

}
