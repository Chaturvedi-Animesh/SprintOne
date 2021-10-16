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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.model.Admin;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.Tournament;
import com.sprintOne.service.AdminService;


@RestController(value="/admin")


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
	
	@PostMapping(value = "/commence/tournament/{tournamentId}")
	public boolean commenceTournament(@PathVariable int tournamentId) {
		return this.adminService.commenceTournament(tournamentId);
	}
	
	@PostMapping(value = "/manage/tournament/{tournamentId}")
	public boolean manageTournament(@PathVariable int tournamentId) {
		return this.adminService.commenceTournament(tournamentId);
	}
	
    @PostMapping(value = "/manage/teams/{teamId}")
    public boolean manageTeams(@PathVariable int teamId) {
    	return this.manageTeams(teamId);
    }
    
    
    
	
	
	
}
