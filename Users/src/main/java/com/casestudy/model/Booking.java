package com.casestudy.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

	@Transient
	public static final String SEQUENCE_NAME = "tickets_sequence";

	@Id
	private long pnr;
	@NotEmpty(message = "username cannot be empty")
	private String username;
	@NotEmpty(message = "Id cannot be empty")
	private String trainId;
	@NotEmpty(message = "name cannot be empty")
	private String name;
	@NotEmpty(message = "date cannot be empty")
	private String date;
	@NotNull(message = "seats cannot be empty")
	@Max(value = 6)
	@Min(value = 1)
	private int seats;
	@NotEmpty(message = "source cannot be empty")
	private String source;
	@NotEmpty(message = "destination cannot be empty")
	private String destination;
	@NotEmpty(message = "quota cannot be empty")
	private String quota;
	@NotNull(message = "Fare cannot be empty")
	private int totalFare;
	
	@NotNull(message = "Depa. time cannot be empty")
	private int departureTime;
	
	@NotNull(message = "arrival time cannot be empty")
	private int arrivalTime;

	private String psgName;

	private int age;

	private String gender;

}
