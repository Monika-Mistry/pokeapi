package com.bae.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.bae.domain.SentHistory;
import com.bae.repository.HistoryRepository;

@Component
public class HistoryService {
	
	private HistoryRepository repository;
	
	public HistoryService(@Autowired HistoryRepository repository) {
		this.repository = repository;
	}
	
	@JmsListener(destination = "HistoryQueue", containerFactory = "jmsFactory")
	public void saveHistory(SentHistory history) {
		System.out.println("Received <" + history + ">");
		
		repository.save(history);
		
		System.out.println(history + " processed ...");
	}

}
