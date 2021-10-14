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
@Table(name = "Match_Schedule")
public class MatchSchedule {
	@Id
	@Column(name = "match_id")
	private int matchId;
	@OneToOne
    @JoinColumn(name = "team_id")
	@Column(name = "team_one_id")
	private Team_Details teamOneId;
	@OneToOne
    @JoinColumn(name = "team_id")
	@Column(name = "team_two_id")
	private Team_Details teamTwoId;
	@Column(name = "match_date")
	private Date matchDate;
	@Column(name = "start_time")
	private LocalTime startTime = LocalTime.now();
	@Column(name = "end_time")
	private LocalTime endTime = LocalTime.now();
	@Column(name = "result")
	private String result;
	
	public MatchSchedule() {
		
	}

	public MatchSchedule(int matchId, Team_Details teamOneId, Team_Details teamTwoId, Date matchDate,
			LocalTime startTime, LocalTime endTime, String result) {
		super();
		this.matchId = matchId;
		this.teamOneId = teamOneId;
		this.teamTwoId = teamTwoId;
		this.matchDate = matchDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.result = result;
	}

	public int getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public Team_Details getTeamOneId() {
		return teamOneId;
	}

	public void setTeamOneId(Team_Details teamOneId) {
		this.teamOneId = teamOneId;
	}

	public Team_Details getTeamTwoId() {
		return teamTwoId;
	}

	public void setTeamTwoId(Team_Details teamTwoId) {
		this.teamTwoId = teamTwoId;
	}

	public Date getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	

}
