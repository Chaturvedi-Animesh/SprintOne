package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamPointsTable 
{
	@Id
	private int teamId;
	private String teamName;
	private int matchesPlayed;
	private int matchesWon;
	private int matchesLost;
	private int matchesDrawn;
	private int points;
	public TeamPointsTable()
	{
		
	}
	public TeamPointsTable(int teamId, String teamName, int matchesPlayed, int matchesWon, int matchesLost,
			int matchesDrawn, int points) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.matchesPlayed = matchesPlayed;
		this.matchesWon = matchesWon;
		this.matchesLost = matchesLost;
		this.matchesDrawn = matchesDrawn;
		this.points = points;
	}
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public int getMatchesWon() {
		return matchesWon;
	}
	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}
	public int getMatchesLost() {
		return matchesLost;
	}
	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}
	public int getMatchesDrawn() {
		return matchesDrawn;
	}
	public void setMatchesDrawn(int matchesDrawn) {
		this.matchesDrawn = matchesDrawn;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	

}
