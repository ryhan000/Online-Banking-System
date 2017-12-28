package com.userFront.dao;

import org.springframework.data.repository.CrudRepository;

import com.userFront.domain.User;

public interface  UserDao  extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	User findByUsername(String username);
	
}
