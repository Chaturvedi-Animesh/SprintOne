package com.sprintOne.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintOne.customException.EmptyMatchDetailsException;
import com.sprintOne.customException.EmptyMatchListException;
import com.sprintOne.customException.NoSuchTeamException;
import com.sprintOne.dao.MatchDetailsDao;
import com.sprintOne.dao.TeamDetailsDao;
import com.sprintOne.dao.TeamPointsTableDao;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

@Service("systemService")
public class SystemServiceImpl implements SystemService {

	@Autowired
	MatchDetailsDao matchDetailsDao;
	
	@Autowired
	TeamPointsTableDao pointsTableDao;
	
	@Autowired
	TeamDetailsDao teamDetailsDao;
	
	@Autowired
	TeamPointsTableDao teamPointsTableDao;
	
	@Override
	public List<MatchDetails> getMatchDetails() throws EmptyMatchListException{
		
		return matchDetailsDao.findAll().stream().filter(match -> match.getDateTime().compareTo(new Date().toString())>0).toList();
		
	}
	
	@Override
	public List<MatchDetails> getAllMatchDetails() throws EmptyMatchDetailsException{
		return matchDetailsDao.findAll();
	}
	
	@Override
	public TeamDetails getTeamDetails(int id) throws NoSuchTeamException{
		if(teamDetailsDao.existsById(id)) {
			return teamDetailsDao.getById(id);
		}else return null;
	}
	
	@Override
	public TeamPointsTable getTeamStat(int id) throws NoSuchTeamException{
		if(teamPointsTableDao.existsById(id)) {
			return teamPointsTableDao.getById(id);
		}else return null;
	}
	
	@Override
	public TeamPointsTable displayteamstats(int id) {
		return teamPointsTableDao.findById(id).get();
	}
	
	
}
