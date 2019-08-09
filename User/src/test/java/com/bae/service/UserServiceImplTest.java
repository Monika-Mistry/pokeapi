package com.bae.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.TestConstants;
import com.bae.repository.UserRepository;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {
	
	@InjectMocks
	private UserServiceImpl service;
	
	@Mock
	private UserRepository repository;
	
	@Test
	public void createUserTest() {
		doReturn(TestConstants.MOCK_USER).when(repository).save(TestConstants.MOCK_USER);
		
		assertEquals(TestConstants.MOCK_USER, service.createUser(TestConstants.MOCK_USER));
		
		verify(repository).save(TestConstants.MOCK_USER);
	}
	
	@Test
	public void findUserThatExists() {
		doReturn(TestConstants.MOCK_USER_OPTIONAL).when(repository).findById(1L);
		
		assertEquals(true, service.userIdExists(1L));
		
		verify(repository).findById(1L);
	}
	
	
	@Test
	public void findUserThatDoesNotExist() {
		doReturn(TestConstants.MOCK_NULL_OPTIONAL).when(repository).findById(2L);
		
		assertEquals(false, service.userIdExists(2L));
		
		verify(repository).findById(2L);
	}

}
