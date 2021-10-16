package com.sprintOne.service;

import java.util.Comparator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintOne.dao.BidderDao;
import com.sprintOne.dao.BiddingDetailsDao;
import com.sprintOne.dao.LeaderboardDao;
import com.sprintOne.dao.MatchDetailsDao;
import com.sprintOne.dao.TeamDetailsDao;
import com.sprintOne.dao.TeamPointsTableDao;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.BiddingDetails;
import com.sprintOne.model.Leaderboard;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

@Service("bidderService")
public class BidderService {
	
	@Autowired
	BidderDao bidderDao;
	@Autowired
	MatchDetailsDao matchDetailsDao;
	@Autowired
	TeamDetailsDao teamDetailsDao;
	@Autowired
	TeamPointsTableDao teamPointsTableDao;
	@Autowired
	LeaderboardDao leaderboardDao;
	@Autowired
	BiddingDetailsDao biddingDetailsDao;
	
	public boolean registerBidder(Bidder bidder, int bidderId) {
		Optional<Bidder> bidderList = bidderDao.findById(bidderId);
		if(bidderList.isPresent()) {
			return false;
		}else {
			bidderDao.save(bidder);
			return true;
		}
	}
	
	public boolean loginBidder(String email, String password) {
		List<Bidder> bidderList=bidderDao.findAll();
			
		for(Bidder bidder:bidderList) {
			if(!email.isEmpty() & !password.isEmpty()) {
				if(bidder.getEmail().equals(email) && bidder.getPassword().equals(password)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	public List<MatchDetails> showMatchDetails() {
		return matchDetailsDao.findAll();
	}
	
	public TeamDetails selectTeam(int teamId) {
		Optional<TeamDetails> teamDetails = teamDetailsDao.findById(teamId);
		if(teamDetails.isPresent()) {
			return teamDetails.get();
		}
		return null;
	}
	
	public void changeTeam(TeamDetails teamdetails) {
		
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
   
    public List<TeamPointsTable> viewPointsTable(){
    	return teamPointsTableDao.findAll().stream().sorted(Comparator.comparingInt(TeamPointsTable :: getPoints)).collect(Collectors.toList()); 
    }
    
    public List<Leaderboard> viewLeaderboard(int bidderId){	
    List<Leaderboard> list= leaderboardDao.findAll().stream().sorted(Comparator.comparingInt(Leaderboard :: getBidderpoints)).limit(3).collect(Collectors.toList());
    list.add(leaderboardDao.getById(bidderId));
    return list;
    }
}
