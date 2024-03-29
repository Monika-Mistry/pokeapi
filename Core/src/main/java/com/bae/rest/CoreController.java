package com.bae.rest;

import java.awt.PageAttributes.MediaType;
import java.sql.Timestamp;
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

import com.bae.domain.History;
import com.bae.domain.User;

@RestController
public class CoreController {

	@Value("${url.userURL}")
	private String userURL;

	@Value("${path.userExists}")
	private String userExistsPath;

	@Value("${path.createUser}")
	private String createUserPath;

	@Value("${url.searchURL}")
	private String searchURL;

	@Value("${path.idSearch}")
	private String idSearchPath;
	
	@Value("${path.nameSearch}")
	private String nameSearchPath;
	
	@Value("${url.history}")
	private String historyURL;

	@Value("${path.historyPath}")
	private String historyPath;

	private RestTemplate restTemplate;

	public CoreController(@Autowired RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {

		HttpEntity<User> requestEntity = new HttpEntity<>(user);
		return restTemplate.exchange(userURL + createUserPath, HttpMethod.POST, requestEntity, User.class);

	}

	@GetMapping("/{userId}")
	public ResponseEntity<Boolean> doesUserExist(@PathVariable("userId") Long userId) {
		return restTemplate.exchange(userURL + userExistsPath + userId, HttpMethod.GET, null, Boolean.class);
	}

	@GetMapping("/{userId}/{pokeId}")
	public ResponseEntity<Object> searchById(@PathVariable("userId") Long userId,
			@PathVariable("pokeId") String pokeId) {

		ResponseEntity<Boolean> user = restTemplate.exchange(userURL + userExistsPath + userId, HttpMethod.GET, null,
				Boolean.class);

		if (user.getBody().booleanValue()) {
			sendToProducer(new History(userId, pokeId, new Timestamp(System.currentTimeMillis())));

			return restTemplate.exchange(searchURL + idSearchPath + pokeId, HttpMethod.GET, null, Object.class);
		} else {
			return new ResponseEntity<Object>("User does not exist", HttpStatus.OK);
		}
	}
//	
//	@GetMapping("/{userId}/searchByName/{name}")
//	public ResponseEntity<Object> searchByName(@PathVariable("userId") Long userId,
//			@PathVariable("name") String name) {
//
//		ResponseEntity<Boolean> user = restTemplate.exchange(userURL + userExistsPath + userId, HttpMethod.GET, null,
//				Boolean.class);
//
//		if (user.getBody().booleanValue()) {
//
//			// TODO: add in link to producer
//			sendToProducer(new History());
//
//			return restTemplate.exchange(searchURL + nameSearchPath + name, HttpMethod.GET, null, Object.class);
//		} else {
//			return new ResponseEntity<Object>("User does not exist", HttpStatus.OK);
//		}
//	}

	@PostMapping("/history")
	public ResponseEntity<History> sendToProducer(History history) {
		HttpEntity<History> requestEntity = new HttpEntity<>(history);
		return restTemplate.exchange(historyURL + historyPath, HttpMethod.POST, requestEntity, History.class);

	}

}
