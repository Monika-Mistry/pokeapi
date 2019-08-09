package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bae.domain.History;
import com.bae.domain.SentHistory;

@RestController
public class HistoryController {

	@Value("${url.core}")
	private String coreURL;

	@Value("${path.getHistory}")
	private String getHistoryPath;

	private JmsTemplate jmsTemplate;
	private RestTemplate restTemplate;

	public HistoryController(@Autowired JmsTemplate jmsTemplate, @Autowired RestTemplate restTemplate) {
		this.jmsTemplate = jmsTemplate;
		this.restTemplate = restTemplate;
	}

	
	@PostMapping("/history")
	public ResponseEntity<History> getHistory(@RequestBody History history) {
		sendToQueue(history);		

		return new ResponseEntity<History>(history, HttpStatus.OK);
	}

	private void sendToQueue(History history) {
		SentHistory historyToStore = new SentHistory(history);
		jmsTemplate.convertAndSend("HistoryQueue", historyToStore);
	}
}
