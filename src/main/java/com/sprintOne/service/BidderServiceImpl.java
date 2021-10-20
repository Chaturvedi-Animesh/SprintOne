package com.sprintOne.service;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Comparator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintOne.customException.InvalidCredentialsException;
import com.sprintOne.customException.UserAlreadyPresentException;
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
public class BidderServiceImpl implements BiddderService {
	
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
	
	@Override
	public boolean registerBidder(Bidder bidder) {
		Optional<Bidder> bidderList = bidderDao.findById(bidder.getUserID());
		List emailList=bidderDao.findAll().stream().map(bidders->bidders.getEmail()).toList();
		if(bidderList.isPresent() || emailList.contains(bidder.getEmail())) {
			return false;
		}else {
			bidder.setPoints(0);
			bidderDao.save(bidder);
			Leaderboard leaderboard=new Leaderboard(bidder.getUserID(), bidder.getName(), 0, 0, 0, 0);
			leaderboardDao.save(leaderboard);
			return true;
		}
	}
	
	@Override
	public boolean loginBidder(String email, String password) throws InvalidCredentialsException{
		List<Bidder> bidderList=bidderDao.findAll();
			
		for(Bidder bidder:bidderList) {
			if(!email.isEmpty() && !password.isEmpty()) {
				if(bidder.getEmail().equals(email) && bidder.getPassword().equals(password)){
					return true;
				}
			}
			
		}
		return false;
	}
	
	@Override
	public List<MatchDetails> showMatchDetails() {
		return matchDetailsDao.findAll();
	}
	
	@Override
	public TeamDetails selectTeam(int teamId) {
		Optional<TeamDetails> teamDetails = teamDetailsDao.findById(teamId);
		if(teamDetails.isPresent()) {
			return teamDetails.get();
		}
		return null;
	}
	
	@Override
	public String changeTeam(int userId) {
		int matchId=biddingDetailsDao.getById(userId).getMatchId();
		if(matchDetailsDao.getById(matchId).getDateTime().isAfter(LocalDateTime.now())) {
			String teamOne=teamDetailsDao.getById(matchDetailsDao.getById(matchId).getTeamOneId()).getTeamName();
			String teamTwo=teamDetailsDao.getById(matchDetailsDao.getById(matchId).getTeamTwoId()).getTeamName();
			BiddingDetails biddingDetails=biddingDetailsDao.getById(userId);
			
			if(biddingDetails.getUserOpinion().equals(teamOne))
				biddingDetails.setUserOpinion(teamTwo);
			else
				biddingDetails.setUserOpinion(teamOne);
			
			biddingDetailsDao.save(biddingDetails);
			
			return "Team Changed";
		}
		
		else return "Cannot Change Team After Match Start";
		
	}	
	
		
	
    @Override
	public void bid(BiddingDetails biddingDetails) {
		biddingDetailsDao.save(biddingDetails);
	}
	
	@Override
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
   
    @Override
	public List<TeamPointsTable> viewPointsTable(){
    	return teamPointsTableDao.findAll().stream().sorted(Comparator.comparingInt(TeamPointsTable :: getPoints)).collect(Collectors.toList()); 
    }
    
    @Override
	public List<Leaderboard> viewLeaderboard(int bidderId){	
    List<Leaderboard> list= leaderboardDao.findAll().stream().sorted(Comparator.comparingInt(Leaderboard :: getBidderpoints)).limit(3).collect(Collectors.toList());
    list.add(leaderboardDao.getById(bidderId));
    return list;
    }
}