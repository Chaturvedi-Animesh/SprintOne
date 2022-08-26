package com.sprintOne.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class MatchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int matchId;
	private int teamOneId;
	private int teamTwoId;
	private String dateTime;
	private String matchStadium;
	private String winner;
	private String status;
	private String delay;
	
	public MatchDetails() {
		
	}

	public MatchDetails(int matchId, int teamOneId, int teamTwoId, String dateTime, String matchStadium,
			String winner, String status, String delay) {
		super();
		this.matchId = matchId;
		this.teamOneId = teamOneId;
		this.teamTwoId = teamTwoId;
		this.dateTime = dateTime;
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

	public void setTeamOneId(int teamOneId) {
		this.teamOneId = teamOneId;
	}

	public int getTeamTwoId() {
		return teamTwoId;
	}

	public void setTeamTwoId(int teamTwoId) {
		this.teamTwoId = teamTwoId;
	}

	public String getDateTime(){
		
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		
		this.dateTime = dateTime;
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
