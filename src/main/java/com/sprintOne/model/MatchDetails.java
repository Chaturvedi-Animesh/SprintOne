package com.sprintOne.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MatchDetails {

	@Id
	private int matchId;
	private int teamOneId;
	private int teamTwoId;
	private Date matchDate;
	private LocalTime matchTime;
	private String matchStadium;
	private String winner;
	private String status;
	private String delay;
	
	public MatchDetails() {
		
	}

	public MatchDetails(int matchId, int teamOne, int teamTwo, Date matchDate, LocalTime matchTime,
			String matchStadium, String winner, String status, String delay) {
		super();
		this.matchId = matchId;
		this.teamOneId = teamOne;
		this.teamTwoId = teamTwo;
		this.matchDate = matchDate;
		this.matchTime = matchTime;
		this.matchStadium = matchStadium;
		this.winner = winner;
		this.status = status;
		this.delay = delay;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public int getTeamOneId() {
		return teamOneId;
	}

	public void setTeamOneId(int teamOne) {
		this.teamOneId = teamOne;
	}

	public int getTeamTwoId() {
		return teamTwoId;
	}

	public void setTeamTwo(int teamTwo) {
		this.teamTwoId = teamTwo;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public LocalTime getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(LocalTime matchTime) {
		this.matchTime = matchTime;
	}

	public String getMatchStadium() {
		return matchStadium;
	}

	public void setMatchStadium(String matchStadium) {
		this.matchStadium = matchStadium;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	
	
}
