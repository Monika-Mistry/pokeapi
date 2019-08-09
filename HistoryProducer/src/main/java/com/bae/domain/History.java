package com.bae.domain;

import java.sql.Timestamp;

public class History {
	private Long id;

	private String memberNumber;

	private String name;

	private String searchTerm;

	private Timestamp timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
