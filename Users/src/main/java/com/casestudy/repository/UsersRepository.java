package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Users;

public interface UsersRepository extends MongoRepository<Users, String> {
	
	
}
