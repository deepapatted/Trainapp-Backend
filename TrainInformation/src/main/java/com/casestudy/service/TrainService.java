package com.casestudy.service;

import java.util.List;
import com.casestudy.model.TrainDetails;

public interface TrainService {

	public List<TrainDetails> getAllTrains();

	public TrainDetails addTrains(TrainDetails trains);

	public List<TrainDetails> checkTrains(String source, String destination);

	public List<TrainDetails> getTrainByName(String search);

	public TrainDetails getTrainById(String search);

	public void updateTrain(TrainDetails trainDetails);

	public String removeTrain(String trainId);

}