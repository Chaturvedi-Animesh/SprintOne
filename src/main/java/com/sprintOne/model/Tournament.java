package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tournament 
{
	@Id
     private int tournamentId;
     private int numberOfQualifiers;
     private int numberOfTeams;
     private int numberOfMatchesCompleted;
     private int matchId;
     public Tournament()
     {
    	 
     }
     public Tournament(int tournamentId, int numberOfQualifiers, int numberOfTeams,	int numberOfMatchesCompleted, int matchId) {
		super();
		this.tournamentId = tournamentId;
		this.numberOfQualifiers = numberOfQualifiers;
		this.numberOfTeams = numberOfTeams;
		this.numberOfMatchesCompleted = numberOfMatchesCompleted;
		this.matchId = matchId;
	}
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public int getNumberOfQualifiers() {
		return numberOfQualifiers;
	}
	public void setNumberOfQualifiers(int numberOfQualifiers) {
		this.numberOfQualifiers = numberOfQualifiers;
	}
	public int getNumberOfTeams() {
		return numberOfTeams;
	}
	public void setNumberOfTeams(int numberOfTeams) {
		this.numberOfTeams = numberOfTeams;
	}
	public int getNumberOfMatchesCompleted() {
		return numberOfMatchesCompleted;
	}
	public void setNumberOfMatchesCompleted(int numberOfMatchesCompleted) {
		this.numberOfMatchesCompleted = numberOfMatchesCompleted;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
     
    
     
}
