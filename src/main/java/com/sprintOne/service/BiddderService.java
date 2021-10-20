package com.sprintOne.service;

import java.util.List;


import com.sprintOne.customException.InvalidCredentialsException;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.BiddingDetails;
import com.sprintOne.model.Leaderboard;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

public interface BiddderService {

	boolean registerBidder(Bidder bidder);

	boolean loginBidder(String email, String password) throws InvalidCredentialsException;

	List<MatchDetails> showMatchDetails();

	TeamDetails selectTeam(int teamId);

	String changeTeam(int userId);

	void bid(BiddingDetails biddingDetails);

	boolean cancelBid(int userId, int matchId);

	List<TeamPointsTable> viewPointsTable();

	List<Leaderboard> viewLeaderboard(int bidderId);

}