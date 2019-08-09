package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.domain.User;
import com.bae.repository.UserRepository;

@Service
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


	public User findById(Long id) {
		return repository.findById(id).get();
	}

}
