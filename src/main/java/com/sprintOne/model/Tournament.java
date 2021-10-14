package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Tournament 
{
	@Id
     private int tournament_Id;
     private int number_of_qualifiers;
     private int number_of_teams;
     private int number_of_matches_completed;
     @OneToOne(fetch = FetchType.LAZY)
 	 @JoinColumn(name = "match_id")
     private int match_id;
     public Tournament()
     {
    	 
     }
	public Tournament(int tournament_Id, int number_of_qualifiers, int number_of_teams, int number_of_matches_completed,
			int match_id) {
		super();
		this.tournament_Id = tournament_Id;
		this.number_of_qualifiers = number_of_qualifiers;
		this.number_of_teams = number_of_teams;
		this.number_of_matches_completed = number_of_matches_completed;
		this.match_id = match_id;
	}
	public int getTournament_Id() {
		return tournament_Id;
	}
	public void setTournament_Id(int tournament_Id) {
		this.tournament_Id = tournament_Id;
	}
	public int getNumber_of_qualifiers() {
		return number_of_qualifiers;
	}
	public void setNumber_of_qualifiers(int number_of_qualifiers) {
		this.number_of_qualifiers = number_of_qualifiers;
	}
	public int getNumber_of_teams() {
		return number_of_teams;
	}
	public void setNumber_of_teams(int number_of_teams) {
		this.number_of_teams = number_of_teams;
	}
	public int getNumber_of_matches_completed() {
		return number_of_matches_completed;
	}
	public void setNumber_of_matches_completed(int number_of_matches_completed) {
		this.number_of_matches_completed = number_of_matches_completed;
	}
	public int getMatch_id() {
		return match_id;
	}
	public void setMatch_id(int match_id) {
		this.match_id = match_id;
	}
     
    
     
}
