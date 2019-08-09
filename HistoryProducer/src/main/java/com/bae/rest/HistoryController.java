package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.domain.History;
import com.bae.domain.SentHistory;

@RestController
public class HistoryController {
	
	@Value("${url.user}")
	private String userURL;
	
	@Value("${path.getHistory}")
	private String getHistoryPath;
	
	private JmsTemplate jmsTemplate;
	private RestTemplate restTemplate;

	public HistoryController(@Autowired JmsTemplate jmsTemplate, @Autowired RestTemplate restTemplate) {
		this.jmsTemplate = jmsTemplate;
		this.restTemplate = restTemplate;
	}
	
	@GetMapping
	public ResponseEntity<History> getHistory() {
		ResponseEntity<History> history = restTemplate.getForEntity(userURL + getHistoryPath, History.class);
		
		sendToQueue(history.getBody());
		
		return history;
	}
	
	
	private void sendToQueue(History history) {
		SentHistory historyToStore = new SentHistory(history);
		jmsTemplate.convertAndSend("HistoryQueue", historyToStore);
	}
}
