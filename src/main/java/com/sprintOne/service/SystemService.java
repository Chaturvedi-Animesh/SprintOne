package com.sprintOne.service;

import java.time.LocalDateTime;
import java.util.Date;
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
		
		List<MatchDetails> matches=matchDetailsDao.findAll().stream().filter(match -> match.getDateTime().isBefore(LocalDateTime.now())).toList();
		return matches;
	}
	
	public List<MatchDetails> getAllMatchDetails(){
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
	
	public TeamPointsTable displayteamstats(int id) {
		return teamPointsTableDao.findById(id).get();
	}
	
	
}
