package com.sprintOne.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.customException.EmptyMatchDetailsException;
import com.sprintOne.customException.EmptyMatchListException;
import com.sprintOne.customException.NoSuchTeamException;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;
import com.sprintOne.service.SystemService;

@RestController(value="/system")
public class SystemController {

	@Autowired
	SystemService systemService;
	
	@GetMapping(value="/stats")
	public ResponseEntity<List<MatchDetails>> matchStatistic() throws EmptyMatchListException{
		List<MatchDetails> matchDetails=systemService.getMatchDetails();
		if(matchDetails.isEmpty()) {
			throw new EmptyMatchListException("Match List is Empty");
		}else
		return new ResponseEntity<>(matchDetails, HttpStatus.OK);
	}
	
	@GetMapping("/team/details/{id}")
	public ResponseEntity<TeamDetails> getTeamDetails(@RequestParam int id) throws NoSuchTeamException{
		TeamDetails teamDetails=systemService.getTeamDetails(id);
		if(teamDetails==null) {
			throw new NoSuchTeamException("No Such Team");
		}
		else
		return new ResponseEntity<>(teamDetails,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/team/stats/{id}")
	public ResponseEntity<TeamPointsTable> getTeamStat(@RequestParam int id) throws NoSuchTeamException{
		TeamPointsTable pointsTable=systemService.getTeamStat(id);
		if(pointsTable==null) {
			throw new NoSuchTeamException("No Such Team");
		}else
		return new ResponseEntity<TeamPointsTable>(pointsTable,HttpStatus.OK);
	}
	
	@GetMapping(value="/matches")
	public ResponseEntity<List<MatchDetails>> getAllMatches() throws EmptyMatchDetailsException{
		List<MatchDetails> list = systemService.getAllMatchDetails();
		if(list.isEmpty()) {
			throw new EmptyMatchDetailsException("Match details are not available");
		}
		else
		    return new ResponseEntity(list,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/teamstats/{id}")
	public ResponseEntity teamstats(@RequestParam int id) throws NoSuchTeamException{
		TeamDetails list=systemService.getTeamDetails(id);
		if(list==null) {
			throw new NoSuchTeamException("No such team");
		}
		else
			return new ResponseEntity(list,HttpStatus.OK);
	}
	
	
}
	
