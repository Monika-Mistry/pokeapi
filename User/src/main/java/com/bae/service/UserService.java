package com.bae.service;

import com.bae.domain.User;

public interface UserService {
	
	public boolean userIdExists(Long id);
	public User createUser(User user);
	public User findById(Long id);
	

}
