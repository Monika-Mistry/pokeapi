package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.domain.User;
import com.bae.service.UserService;

@RestController
public class UserController {
	
	private UserService service;
	private RestTemplate restTemplate;
	
	public UserController(@Autowired UserService service, @Autowired RestTemplate restTemplate) {
		this.service = service;
		this.restTemplate = restTemplate;
	}

	
	@GetMapping("/{userId}")
	public ResponseEntity<Boolean> doesUserExist(@PathVariable("userId") Long id) {
		return new ResponseEntity<Boolean>(service.userIdExists(id), HttpStatus.OK);
	}
		
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(service.createUser(user), HttpStatus.CREATED);
	}
}
