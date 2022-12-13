package com.casestudy.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@Id
	private String username;
	@NotEmpty(message = "name cannot be empty")
	private String name;
	@NotNull(message = "age cannot be empty")
	private int age;
	@NotEmpty(message = "gender cannot be empty")
	private String gender;
	@Email(message = "mail cannot be empty")
	private String email;
	@NotEmpty(message = "password cannot be empty")
	private String password;
	@NotNull(message = "contact cannot be empty")
	private long contact;
	private String roles;
	private List<Booking> bookings;
	


}
