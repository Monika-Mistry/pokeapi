package com.bae.service;

import com.bae.domain.User;

public interface UserService {
	
	public User findById(Long id);
	public User createUser(User user);
	

}
