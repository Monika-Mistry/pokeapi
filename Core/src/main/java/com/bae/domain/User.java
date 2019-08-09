package com.bae.domain;

public class User {
private Long id;
	
	private String memberNumber;
	
	private String name;

	public User(long id, String memberNumber, String name) {
		this.id = id;
		this.memberNumber = memberNumber;
		this.name = name;
	}
	
	public User() {

	}

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

}
