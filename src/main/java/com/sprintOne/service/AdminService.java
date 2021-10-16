package com.sprintOne.service;


import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sprintOne.model.Admin;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.BiddingDetails;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.MatchSchedule;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.Tournament;
import com.sprintOne.dao.AdminDao;
import com.sprintOne.dao.BidderDao;
import com.sprintOne.dao.BiddingDetailsDao;
import com.sprintOne.dao.MatchDetailsDao;
import com.sprintOne.dao.MatchScheduleDao;
import com.sprintOne.dao.TeamDetailsDao;
import com.sprintOne.dao.TournamentDao;

@Service
public class AdminService {
	@Autowired
	TournamentDao tournamentDao;
	
	@Autowired
	MatchScheduleDao matchScheduleDao;
	
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
	
	int addMatch;
	
	//email validation
	public void registerUser(Bidder bidder) {
		bidderDao.save(bidder);
	}
      
	public boolean manageTournament(Admin admin, int tournamentId) {
		Optional<Admin> adminList = adminDao.findById(tournamentId);
		if(adminList.isPresent()) {
			return false;
		}else {
			adminDao.save(admin);
			return true;
		}
	}
	
	
	/*public void scheduleMatches(Admin admin) {
		MatchSchedule matchSchedule = new MatchSchedule(1,"team 1","team 2", new Date(2021,02,03), LocalTime.of(20, 10), LocalTime.of(23, 10), "team 1");
		matchScheduleDao.save(matchSchedule);
		
	}*/
	
	public boolean rescheduleMatches(int matchId) {
		List<MatchDetails> md = matchDetailsDao.findAll();
		for(MatchDetails m : md) {
			if(addMatch == matchId) {
				md.add(m);
				return true;
			}
	}
		return false;
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
	
	
	
	public void updateTeamStatistics(Admin admin) {
		
	}
	
	
	public boolean commenceTournament(int tournamentId) {
		List<Tournament> tournament1 = tournamentDao.findAll();
		for(Tournament t :tournament1) {
			if(t.getTournamentId() == tournamentId) {
				tournament1.remove(tournamentId);
				return true;        
				}
			}
		return false;
	}
	
	

}