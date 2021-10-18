package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BiddingDetails {

	@Id
	private int userId;
	private int matchId;
	private String userOpinion;
	
	public BiddingDetails() {
	}

	public BiddingDetails(int userId, int matchId, String userOpinion) {
		super();
		this.userId = userId;
		this.matchId = matchId;
		this.userOpinion = userOpinion;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public String getUserOpinion() {
		return userOpinion;
	}

	public void setUserOpinion(String userOpinion) {
		this.userOpinion = userOpinion;
	}
	
	
}
