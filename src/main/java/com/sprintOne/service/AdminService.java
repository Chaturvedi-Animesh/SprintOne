package com.sprintOne.service;


import java.util.List;
import java.util.Map;

import com.sprintOne.customException.BidderNotFoundException;
import com.sprintOne.customException.MatchNotFoundException;
import com.sprintOne.model.Bidder;

import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.Tournament;


public interface AdminService {
	
	void registerUser(Bidder bidder);
	
	boolean addTeam(TeamDetails teamDetails);
	
	boolean scheduleMatches(MatchDetails details);
	
	MatchDetails rescheduleMatches(int matchId);
	
	boolean cancelMatch(int matchId ) throws MatchNotFoundException;
	
	Bidder viewBidder(int id) throws BidderNotFoundException;
	
	TeamDetails manageTeams(int teamId);
	
	void declareResult(Map<String, String> map);
	
	boolean commenceTournament(Tournament tournament);
	
	List<MatchDetails> updateMatch(MatchDetails details);
	
	long noOfBidders(int teamId);
	
	double biddingPercentage(int matchId);
	

	

}
