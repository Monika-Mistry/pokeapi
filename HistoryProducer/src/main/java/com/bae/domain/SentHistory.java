package com.bae.domain;

import java.sql.Timestamp;

public class SentHistory {

	private Long id;

	private Long userId;


	private String searchTerm;

	private Timestamp timestamp;

	public SentHistory() {
	
	}

	public SentHistory(History history) {
		this.id = history.getId();
		this.userId = history.getUserId();
		this.searchTerm = history.getSearchTerm();
		this.timestamp = history.getTimestamp();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSearchTerm() {
		return searchTerm;
	}

	public void setSearchTerm(String searchTerm) {
		this.searchTerm = searchTerm;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
