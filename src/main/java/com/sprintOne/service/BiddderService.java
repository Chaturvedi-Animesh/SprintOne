package com.sprintOne.service;

import java.util.List;

import com.sprintOne.customException.EmptyLeaderboardException;
import com.sprintOne.customException.EmptyTeamLeaderboardException;
import com.sprintOne.customException.InvalidCredentialsException;
import com.sprintOne.customException.NoSuchTeamException;
import com.sprintOne.customException.UserAlreadyPresentException;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.BiddingDetails;
import com.sprintOne.model.Leaderboard;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

public interface BiddderService {

	boolean registerBidder(Bidder bidder) throws UserAlreadyPresentException;

	boolean loginBidder(String email, String password) throws InvalidCredentialsException;

	List<MatchDetails> showMatchDetails();

	TeamDetails selectTeam(int teamId) throws NoSuchTeamException;

	String changeTeam(int userId);

	void bid(BiddingDetails biddingDetails);

	boolean cancelBid(int userId, int matchId);

	List<TeamPointsTable> viewPointsTable() throws EmptyTeamLeaderboardException;

	List<Leaderboard> viewLeaderboard(int bidderId) throws EmptyLeaderboardException;

}