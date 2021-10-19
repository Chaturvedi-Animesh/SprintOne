package com.sprintOne.service;


import java.time.LocalTime;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintOne.dao.AdminDao;
import com.sprintOne.dao.BidderDao;
import com.sprintOne.dao.BiddingDetailsDao;
import com.sprintOne.dao.MatchDetailsDao;
import com.sprintOne.dao.TeamDetailsDao;
import com.sprintOne.dao.TeamPointsTableDao;
import com.sprintOne.dao.TournamentDao;
import com.sprintOne.model.Admin;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.BiddingDetails;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;
import com.sprintOne.model.Tournament;

@Service
public class AdminService {
	@Autowired
	TournamentDao tournamentDao;
	
	
	@Autowired
	TeamDetailsDao teamDetailsDao;
	
	@Autowired
	BiddingDetailsDao biddingDetailsDao;
	
	@Autowired
	MatchDetailsDao matchDetailsDao;
	
	@Autowired
	BidderDao bidderDao;
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	TeamPointsTableDao pointsTableDao;
	
	int addMatch;
	
	//email validation
	public void registerUser(Bidder bidder) {
		bidderDao.save(bidder);
	}
	
	public boolean addTeam(TeamDetails teamDetails) {
		if(teamDetails.getTeamPlayers().length!=4)
			return false;
		else {
		teamDetailsDao.save(teamDetails);
		TeamPointsTable pointsTable=new TeamPointsTable(teamDetails.getTeamId(), teamDetails.getTeamName(), 0, 0, 0, 0, 0);
		return true;
	}}
      
	public boolean manageTournament(Admin admin, int tournamentId) {
		Optional<Admin> adminList = adminDao.findById(tournamentId);
		if(adminList.isPresent()) {
			return false;
		}else {
			adminDao.save(admin);
			return true;
		}
	}
	
	
	public boolean scheduleMatches(MatchDetails details) {
		int teamOneId=details.getTeamOneId();
		int teamTwoId=details.getTeamTwoId();
		
		if(teamDetailsDao.findById(teamOneId).isPresent() && teamDetailsDao.findById(teamTwoId).isPresent()) {
		matchDetailsDao.save(details);
		return true;
		}
		else
			return false;
	}
	
	public MatchDetails rescheduleMatches(int matchId) {
		MatchDetails details=matchDetailsDao.findById(matchId).get();
		if(details==null)
			return null;
		details.setDelay("Delay due to bad weather");
		details.setDateTime(details.getDateTime().plusMinutes(30));
		matchDetailsDao.save(details);
		return details;
	}
	
	public boolean cancelMatch(int matchId ) {
		List<MatchDetails> md = matchDetailsDao.findAll();
		for(MatchDetails m : md) {
			if(m.getMatchId() == matchId) {
				int addMatch = m.getMatchId();
						md.remove(matchId);
				return true;
			}
		}
		return false;
	}
	
	
	public Bidder viewBidder(int id) {
		return bidderDao.findById(id).get();
	}
	
	
	public TeamDetails manageTeams(int teamId) {
		Optional<TeamDetails> teamDetails = teamDetailsDao.findById(teamId);
		if(teamDetails.isPresent()) {
			return teamDetails.get();
		}
		return null;
	}
	
	
	
	public void declareResult(Map<String, String> map) {
		String winner=map.get("winner");
		String loser=map.get("loser");
		int matchId=Integer.parseInt(map.get("matchId"));
		
		MatchDetails details=matchDetailsDao.findById(matchId).get();
		
		details.setStatus("completed");
		details.setWinner(winner);
		
		matchDetailsDao.save(details);
		
		List<TeamPointsTable> pointsTable= pointsTableDao.findAll();
		
		for(int i=0;i<pointsTable.size();i++) {
			if(pointsTable.get(i).getTeamName().equals(winner)) {
				pointsTable.get(i).setMatchesPlayed(pointsTable.get(i).getMatchesPlayed()+1);
				pointsTable.get(i).setMatchesWon(pointsTable.get(i).getMatchesWon()+1);
				
			}
			if(pointsTable.get(i).getTeamName().equals(loser)) {
				pointsTable.get(i).setMatchesPlayed(pointsTable.get(i).getMatchesPlayed()+1);
				pointsTable.get(i).setMatchesLost(pointsTable.get(i).getMatchesLost()+1);
				
			}
		}
		
		pointsTableDao.deleteAll();
		pointsTableDao.saveAll(pointsTable);
		
		
		
	}
	
	
	public boolean commenceTournament(Tournament tournament) {
		if(tournament.getNumberOfTeams()!=8)
			return false;
		if(tournamentDao.findById(tournament.getTournamentId()).isPresent())
			return false;
		tournamentDao.save(tournament);
		return true;
		
	}
	
	public List<MatchDetails> updateMatch(MatchDetails details) {
		if(matchDetailsDao.existsById(details.getMatchId())) {
			matchDetailsDao.save(details);
			return matchDetailsDao.findAll();
		}else return null;
	}
	
	public long noOfBidders(int teamId) {
		if(teamDetailsDao.findById(teamId).isEmpty())
			return -1;
		else {
			String teamName=teamDetailsDao.findById(teamId).get().getTeamName();
			long count=biddingDetailsDao.findAll().stream().filter(bidding->bidding.getUserOpinion().equals(teamName)).count();
			return count;
		}
	}
	
	public double biddingPercentage(int matchId) {
		int teamOneId=matchDetailsDao.findById(matchId).get().getTeamOneId();
		int teamTwoId=matchDetailsDao.findById(matchId).get().getTeamTwoId();
		
		
	}
	
	

}
