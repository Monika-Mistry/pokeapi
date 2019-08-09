package com.bae.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.bae.domain.History;
import com.bae.domain.SentHistory;

@RestController
public class HistoryController {
	
	private JmsTemplate jmsTemplate;

	public HistoryController(@Autowired JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	private void sentToQueue(History history) {
		SentHistory historyToStore = new SentHistory(history);
		jmsTemplate.convertAndSend("HistoryQueue", historyToStore);
	}
}
