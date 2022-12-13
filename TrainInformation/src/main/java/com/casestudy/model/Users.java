package com.casestudy.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	@Id
	private String username;
	private String name;
	private int age;
	private String gender;
	private String email;
	private String password;
	private long contact;
	private String roles;
	
	
}
