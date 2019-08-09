package com.bae.domain;

import java.sql.Timestamp;

public class History {
	private Long id;

	private Long userId;

	private String searchTerm;

	private Timestamp timestamp;
	
	public History() {
		
	}
	

	public History(Long id, Long userId, String searchTerm, Timestamp timestamp) {
		super();
		this.id = id;
		this.userId = userId;
		this.searchTerm = searchTerm;
		this.timestamp = timestamp;
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
