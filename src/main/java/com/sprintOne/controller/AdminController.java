package com.sprintOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.model.Admin;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.Tournament;
import com.sprintOne.service.AdminService;
import com.sprintOne.model.MatchSchedule;


@RestController(value = "/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	
	@GetMapping("/bidder/{id}")
	public ResponseEntity<Bidder> getBidder(@RequestParam int id) {
		Bidder bidder = adminService.viewBidder(id);
		if(bidder==null) {
			return new ResponseEntity("No Such bidder",HttpStatus.BAD_REQUEST);
		}
		else
		return new ResponseEntity<>(bidder,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public boolean cancelMatch(int matchId) {
		return this.adminService.cancelMatch(matchId);
	}
	
	@PostMapping(value="/reschedule/match/{matchId}")
	public boolean rescheduleMatches(@PathVariable int matchId) {
		return this.adminService.rescheduleMatches(matchId);
	}
	
	@PostMapping(value = "/commence/tournament")
	public ResponseEntity commenceTournament(@RequestBody Tournament tournament) {
		boolean flag=adminService.commenceTournament(tournament);
		if(flag) {
			return new ResponseEntity("Tournament Commenced",HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity("Cannot Commence Tornament",HttpStatus.BAD_REQUEST);
	}
	
//	@PostMapping(value = "/manage/tournament/{tournamentId}")
//	public boolean manageTournament(@PathVariable int tournamentId) {
//		return this.adminService.commenceTournament(tournamentId);
//	}
	
//    @PostMapping(value = "/manage/teams/{teamId}")
//    public boolean manageTeams(@PathVariable int teamId) {
//    	return this.manageTeams(teamId);
//    }
    
    @PostMapping(value="/schedule/match")
    public ResponseEntity scheduleMatch(@RequestBody MatchDetails details) {
    	boolean flag=adminService.scheduleMatches(details);
    	if(flag)
    	return new ResponseEntity("Match Scheduled",HttpStatus.OK);
    	else
    		return new ResponseEntity("Match Cannot be Scheduled",HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(value="/add/team")
    public ResponseEntity addTeam(@RequestBody TeamDetails details) {
    	boolean flag=adminService.addTeam(details);
    	if(flag)
    		return new ResponseEntity("Team added",HttpStatus.OK);
    	else
    		return new ResponseEntity("Unable to add Team",HttpStatus.BAD_REQUEST);
    }
    
    
    
	
	
	
}