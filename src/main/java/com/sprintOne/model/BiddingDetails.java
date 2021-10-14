package com.sprintOne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BiddingDetails {

	@Id
	@Column(name = "user_id")
	private int userId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "match_id")
	private int matchId;
	
	@Column(name = "user_opinion")
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
