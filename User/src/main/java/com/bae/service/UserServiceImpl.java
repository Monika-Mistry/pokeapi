package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bae.domain.User;
import com.bae.repository.UserRepository;

public class UserServiceImpl implements UserService{
	
	private UserRepository repository;
	
	public UserServiceImpl(@Autowired UserRepository repository) {
		this.repository = repository;
	}


	public boolean userIdExists(Long id) {
		return repository.findById(id).isPresent();
	}

	public User createUser(User user) {
		return repository.save(user);
	}

}
