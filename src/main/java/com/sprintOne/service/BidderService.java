package com.sprintOne.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.sprintOne.dao.BidderDao;
import com.sprintOne.dao.BiddingDetailsDao;
import com.sprintOne.dao.LeaderboardDao;
import com.sprintOne.dao.TeamDetailsDao;
import com.sprintOne.dao.TeamPointsTableDao;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.BiddingDetails;
import com.sprintOne.model.TeamDetails;

@Service
public class BidderService {
	
	@Autowired
	BidderDao bidderDao;
	
	@Autowired
	BiddingDetailsDao biddingDetailsDao;
	
	@Autowired
	TeamPointsTableDao teamPointsTableDao; 
	
	@Autowired
	LeaderboardDao leaderboardDao;
	
	@Autowired
	TeamDetailsDao teamDetailsDao; 
	
	
	
	public void registerBidder(Bidder bidder) {
		
		bidderDao.save(bidder);
	}
	
	public boolean loginBidder(String email, String password) {
		
		List<Bidder> bidderList=bidderDao.findAll();
		
		for(Bidder bidder:bidderList) {
			if(bidder.getEmail().equals(email) && bidder.getPassword().equals(password)){
				return true;
			}
		}
		
		return false;
	}
	
	public void bid(BiddingDetails biddingDetails) {
		
		biddingDetailsDao.save(biddingDetails);
	}
	
	public boolean cancelBid(int userId, int matchId) {
		List<BiddingDetails> biddingDetails = biddingDetailsDao.findAll();
		
		for(BiddingDetails list: biddingDetails) {
			if(list.getUserId() == userId && list.getMatchId() == matchId) {
				biddingDetails.remove(list);
				return true;
			}
		}
		return false;
	}
	
	public TeamDetails SelectTeam(int teamId) {
		Optional<TeamDetails> teamDetails = teamDetailsDao.findById(teamId);
		if(teamDetails.isPresent()) {
			return teamDetails.get();
		}
		return null;
	}
	

	public boolean changeTeam(int teamId, String teamName) {
		
		return false;
	}
}
