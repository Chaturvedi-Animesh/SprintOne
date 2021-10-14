package com.sprintOne.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Match_Details")
public class MatchDetails {

	@Id
	@Column(name = "match_id")
	private int matchId;
	@OneToOne
    @JoinColumn(name = "team_name")
	@Column(name = "team_one")
	private Team_Details teamOne;
	@OneToOne
    @JoinColumn(name = "team_name")
	@Column(name = "team_two")
	private Team_Details teamTwo;
	@Column(name = "match_date")
	private Date matchDate;
	@Column(name = "match_time")
	private LocalTime matchTime = LocalTime.now();
	@Column(name = "match_stadium")
	private String matchStadium;
	@Column(name = "winner")
	private String winner;
	@Column(name = "status")
	private String status;
	@Column(name = "delay")
	private String delay;
	
	public MatchDetails() {
		
	}

	public MatchDetails(int matchId, Team_Details teamOne, Team_Details teamTwo, Date matchDate, LocalTime matchTime,
			String matchStadium, String winner, String status, String delay) {
		super();
		this.matchId = matchId;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
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

	public Team_Details getTeamOne() {
		return teamOne;
	}

	public void setTeamOne(Team_Details teamOne) {
		this.teamOne = teamOne;
	}

	public Team_Details getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(Team_Details teamTwo) {
		this.teamTwo = teamTwo;
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
