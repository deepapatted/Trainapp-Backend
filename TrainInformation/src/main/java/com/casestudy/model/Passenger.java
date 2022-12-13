package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data @AllArgsConstructor @NoArgsConstructor
public class Passenger {
	
//	@Transient
//    public static final String SEQUENCE_NAME = "passenger_sequence";
//	
//	@Id
//	private int passengerId;
	
	private String psgName;
	
	private int age;
	
	private String gender;

}
