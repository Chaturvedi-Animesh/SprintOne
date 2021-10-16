package com.sprintOne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintOne.dao.MatchDetailsDao;
import com.sprintOne.dao.TeamDetailsDao;
import com.sprintOne.dao.TeamPointsTableDao;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

@Service
public class SystemService {

	@Autowired
	MatchDetailsDao matchDetailsDao;
	
	@Autowired
	TeamPointsTableDao pointsTableDao;
	
	@Autowired
	TeamDetailsDao teamDetailsDao;
	
	@Autowired
	TeamPointsTableDao teamPointsTableDao;
	
	public List<MatchDetails> getMatchDetails(){
		return matchDetailsDao.findAll();
	}
	
	public TeamDetails getTeamDetails(int id) {
		if(teamDetailsDao.existsById(id)) {
			return teamDetailsDao.getById(id);
		}else return null;
	}
	
	public TeamPointsTable getTeamStat(int id) {
		if(teamPointsTableDao.existsById(id)) {
			return teamPointsTableDao.getById(id);
		}else return null;
	}
	
	public void updateMatchDelay(int matchId, String delay) {
		MatchDetails details=matchDetailsDao.getById(matchId);
		details.setDelay(delay);
		details.setStatus("delayed");
		matchDetailsDao.saveAndFlush(details);
	}
	
	public void startMatch(int matchId) {
		MatchDetails details=matchDetailsDao.getById(matchId);
		details.setDelay("none");
		details.setStatus("started");
		matchDetailsDao.saveAndFlush(details);
	}
	
	public void updateWinner(int matchId, String winner) {
		MatchDetails details=matchDetailsDao.getById(matchId);
		details.setDelay("none");
		details.setStatus("comppleted");
		details.setWinner(winner);
		matchDetailsDao.saveAndFlush(details);
		
		List<TeamPointsTable> pointsTable=pointsTableDao.findAll();
		
//		for(int i=0;i<pointsTable.size();i++) {
//			if(pointsTable.get(i).get)
//		}
	}
	
	
}
