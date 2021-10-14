package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TeamPoints_Table 
{
	@Id
	private int team_id;
	private String team_name;
	private int matches_played;
	private int matches_won;
	private int matches_lost;
	private int matches_drawn;
	private int points;
	public TeamPoints_Table()
	{
		
	}
	public TeamPoints_Table(int team_id, String team_name, int matches_played, int matches_won, int matches_lost,
			int matches_drawn, int points) {
		super();
		this.team_id = team_id;
		this.team_name = team_name;
		this.matches_played = matches_played;
		this.matches_won = matches_won;
		this.matches_lost = matches_lost;
		this.matches_drawn = matches_drawn;
		this.points = points;
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
	public int getMatches_played() {
		return matches_played;
	}
	public void setMatches_played(int matches_played) {
		this.matches_played = matches_played;
	}
	public int getMatches_won() {
		return matches_won;
	}
	public void setMatches_won(int matches_won) {
		this.matches_won = matches_won;
	}
	public int getMatches_lost() {
		return matches_lost;
	}
	public void setMatches_lost(int matches_lost) {
		this.matches_lost = matches_lost;
	}
	public int getMatches_drawn() {
		return matches_drawn;
	}
	public void setMatches_drawn(int matches_drawn) {
		this.matches_drawn = matches_drawn;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	

}
