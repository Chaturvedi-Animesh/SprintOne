package com.sprintOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;
import com.sprintOne.service.SystemService;

@RestController(value="/system")
public class SystemController {

	@Autowired
	SystemService systemService;
	
	@GetMapping(value="/stats")
	public ResponseEntity<List<MatchDetails>> matchStatistic() {
		List<MatchDetails> matchDetails=systemService.getMatchDetails();
		if(matchDetails==null) {
			return new ResponseEntity("Match List is Empty",HttpStatus.BAD_REQUEST);
		}else
		return new ResponseEntity<>(matchDetails, HttpStatus.OK);
	}
	
	@GetMapping("/team/details/{id}")
	public ResponseEntity<TeamDetails> getTeamDetails(@RequestParam int id) {
		TeamDetails teamDetails=systemService.getTeamDetails(id);
		if(teamDetails==null) {
			return new ResponseEntity("No Such Team",HttpStatus.BAD_REQUEST);
		}
		else
		return new ResponseEntity<>(teamDetails,HttpStatus.OK);
		
	}
	
	@GetMapping(value="/team/stats/{id}")
	public ResponseEntity<TeamPointsTable> getTeamStat(@RequestParam int id){
		TeamPointsTable pointsTable=systemService.getTeamStat(id);
		if(pointsTable==null) {
			return new ResponseEntity("No Such Team",HttpStatus.BAD_REQUEST);
		}else
		return new ResponseEntity<TeamPointsTable>(pointsTable,HttpStatus.OK);
	}
	
	@GetMapping(value="/matches")
	public ResponseEntity getAllMatches() {
		
		return new ResponseEntity(systemService.getAllMatchDetails(),HttpStatus.OK);
		
	}
	
	@GetMapping(value="/teamstats/{id}")
	public ResponseEntity teamstats(@RequestParam int id) {
		TeamDetails list=systemService.getTeamDetails(id);
		if(list==null) {
			return new ResponseEntity("No such team", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity(list,HttpStatus.OK);
	}
	
	
}
	
