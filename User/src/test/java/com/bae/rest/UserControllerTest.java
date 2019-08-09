package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.TestConstants;
import com.bae.service.UserService;

@RunWith(SpringRunner.class)
public class UserControllerTest {

	@InjectMocks
	private UserController controller;

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private UserService service;

	@Test
	public void createUserTest() {
		doReturn(TestConstants.MOCK_USER).when(service).createUser(TestConstants.MOCK_USER);

		assertEquals(TestConstants.MOCK_USER_RESPONSE, controller.createUser(TestConstants.MOCK_USER));

		verify(service).createUser(TestConstants.MOCK_USER);
	}

	@Test
	public void findUserThatExists() {
		doReturn(true).when(service).userIdExists(1L);

		assertEquals(TestConstants.MOCK_USER_EXISTS, controller.doesUserExist(1L));

		verify(service).userIdExists(1L);
	}

	@Test
	public void findUserThatDoesNotExist() {
		doReturn(false).when(service).userIdExists(2L);

		assertEquals(TestConstants.MOCK_USER_NOT_EXISTS, controller.doesUserExist(2L));

		verify(service).userIdExists(2L);
	}
}
