package com.bae.rest;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.domain.User;

@RestController
public class CoreController {

	@Value("${url.userURL}")
	private String userURL;
	
	@Value("${path.userExists}")
	private String userExistsPath;
	
	@Value("${path.createUser}")
	private String createUserPath;
	
	private RestTemplate restTemplate;

	public CoreController(@Autowired RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		
		HttpEntity<User> requestEntity = new HttpEntity<>(user);
		
//		return new ResponseEntity<User>(user, HttpStatus.CREATED);
		return restTemplate.exchange(userURL + createUserPath, HttpMethod.POST, requestEntity, User.class);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<Boolean> doesUserExist(@PathVariable("userId") Long id) {
		return restTemplate.exchange(userURL + userExistsPath + id, HttpMethod.GET, null, Boolean.class);
	}

}
