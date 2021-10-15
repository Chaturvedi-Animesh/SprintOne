package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class TeamDetails {
	
	@Id
	private int teamId;
	private String teamName;
	private String homeGround;
	private String teamPlayers;
	private String captain;
	
	public TeamDetails() {
		
	}
	
	public TeamDetails(int teamId, String teamName, String homeGround, String teamPlayers, String captain) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.homeGround = homeGround;
		this.teamPlayers = teamPlayers;
		this.captain = captain;
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
	public void setTeamName(String teamName){
		this.teamName = teamName;
	}
	public String getHomeGround() {
		return homeGround;
	}
	public void setHomeGround(String homeGround){
		this.homeGround = homeGround;
	}
	public String getTeamPlayers() {
		return teamPlayers;
	}
	public void setTeamPlayers(String teamPlayers) {
		this.teamPlayers = teamPlayers;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	
	
	

}
