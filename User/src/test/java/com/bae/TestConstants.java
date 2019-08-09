package com.bae;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bae.domain.User;

public class TestConstants {
	
	public static final User MOCK_USER = new User(1L, "1", "John");
	public static final Optional<User> MOCK_USER_OPTIONAL = Optional.of(new User(1L, "1", "John"));
	public static final Optional<User> MOCK_NULL_OPTIONAL = Optional.empty();
	public static final ResponseEntity<User> MOCK_USER_RESPONSE = new ResponseEntity<User>(MOCK_USER, HttpStatus.CREATED);
	public static final ResponseEntity<Boolean> MOCK_USER_EXISTS = new ResponseEntity<Boolean>(true, HttpStatus.OK);
	public static final ResponseEntity<Boolean> MOCK_USER_NOT_EXISTS = new ResponseEntity<Boolean>(false, HttpStatus.OK);

}
