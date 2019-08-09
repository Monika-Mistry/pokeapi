package com.bae.rest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.bae.TestConstants;
import com.bae.domain.History;

@RunWith(SpringRunner.class)
public class HistoryControllerTest {
	
	@InjectMocks
	private HistoryController controller;
	
	@Mock
	private RestTemplate restTemplate;
	
	@Mock
	private JmsTemplate jmsTemplate;
	
	@Ignore
	@Test
	public void getHistoryTest() {
		doReturn(TestConstants.MOCK_HISTORY_RESPONSE).when(restTemplate).getForEntity(TestConstants.MOCK_GETHISTORY_URL, History.class);
		
		assertEquals(TestConstants.MOCK_HISTORY_RESPONSE, controller.getHistory());
		
		verify(restTemplate).getForEntity(TestConstants.MOCK_GETHISTORY_URL, History.class);
	}

}
