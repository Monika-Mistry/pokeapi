package com.bae.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
public class HistoryControllerTest {
	
	@InjectMocks
	private HistoryController controller;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private JmsTemplate jmsTemplate;
	
	@Test
	public void getHistoryTest() {
	}

}
