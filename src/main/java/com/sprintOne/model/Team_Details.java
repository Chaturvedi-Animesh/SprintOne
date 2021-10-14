package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Team_Details {
	
	@Id
	private int team_id;
	private String team_name;
	private String home_ground;
	private String team_players;
	private String captain;
	
	public Team_Details() {
		
	}
	
	public Team_Details(int team_id, String team_name, String home_ground, String team_players, String captain) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.home_ground = home_ground;
		this.team_players = team_players;
		this.captain = captain;
	}
	
	
	public int getTeam_id() {
		return team_id;
	}
	public void setTeam_id(int team_id) {
		this.team_id = team_id;
	}
	public String getTeam_name() {
		return team_name;
	}
	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}
	public String getHome_ground() {
		return home_ground;
	}
	public void setHome_ground(String home_ground) {
		this.home_ground = home_ground;
	}
	public String getTeam_players() {
		return team_players;
	}
	public void setTeam_players(String team_players) {
		this.team_players = team_players;
	}
	public String getCaptain() {
		return captain;
	}
	public void setCaptain(String captain) {
		this.captain = captain;
	}
	
	
	

}
