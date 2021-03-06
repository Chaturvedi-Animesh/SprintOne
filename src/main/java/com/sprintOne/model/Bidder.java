package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bidder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userID;
	
	private String name;
	
	private String email;
	private String password;
	private String mobile;
	
	private int points;
	
	public Bidder() {
		
	}
	
	public Bidder(int userID, String name, String email, String password, String mobile, int points) {
		super();
		this.userID = userID;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.points = points;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
	
	
	

}
