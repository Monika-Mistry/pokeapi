package com.bae;

import java.util.Optional;

import com.bae.domain.User;

public class TestConstants {
	
	public static final User MOCK_USER = new User(1L, "1", "John");
	public static final Optional<User> MOCK_USER_OPTIONAL = Optional.of(new User(1L, "1", "John"));
	public static final Optional<User> MOCK_NULL_OPTIONAL = Optional.empty();

}
