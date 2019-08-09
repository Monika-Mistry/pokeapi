package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	private RestTemplate restTemplate;

	public CoreController(@Autowired RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return new ResponseEntity<User>(user, HttpStatus.CREATED);

	}

	@GetMapping("/{userId}")
	public boolean doesUserExist(@PathVariable("userId") Long id) {
		return restTemplate.exchange(userURL + userExistsPath + id, HttpMethod.GET, null, boolean.class);
	}

}
