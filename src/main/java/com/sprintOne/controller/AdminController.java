package com.sprintOne.controller;

import java.util.List;
import java.util.Map;

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
	public ResponseEntity getBidder(@RequestParam int id) {
		Bidder bidder = adminService.viewBidder(id);
		if(bidder==null) {
			return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
		}
		else
		return new ResponseEntity(bidder,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public boolean cancelMatch(int matchId) {
		return this.adminService.cancelMatch(matchId);
	}
	
	@PostMapping(value="/reschedule")
	public ResponseEntity<?> rescheduleMatches(@RequestParam int matchId) {
		MatchDetails details=adminService.rescheduleMatches(matchId);
		if(details==null)
			return new ResponseEntity<Object>("unable to reschedule",HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity<Object>(details,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/commence/tournament")
	public ResponseEntity<?> commenceTournament(@RequestBody Tournament tournament) {
		boolean flag=adminService.commenceTournament(tournament);
		if(flag) {
			return new ResponseEntity<Object>("Tournament Commenced",HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<Object>("Cannot Commence Tornament",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/result")
	public ResponseEntity<?> declareResult(@RequestParam Map<String, String> matchresult) {
		
		adminService.declareResult(matchresult);
		
		
		return new ResponseEntity<Object>("Result Declared Succesfully",HttpStatus.OK);
		
	}
    
    @PostMapping(value="/schedulematch")
    public ResponseEntity<?> scheduleMatch(@RequestBody MatchDetails details) {
    	boolean flag=adminService.scheduleMatches(details);
    	if(flag)
    	return new ResponseEntity<Object>("Match Scheduled",HttpStatus.OK);
    	else
    		return new ResponseEntity<Object>("Match Cannot be Scheduled",HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(value="/add/team")
    public ResponseEntity<?> addTeam(@RequestBody TeamDetails details) {
    	boolean flag=adminService.addTeam(details);
    	if(flag)
    		return new ResponseEntity<Object>("Team added",HttpStatus.OK);
    	else
    		return new ResponseEntity<Object>("Unable to add Team",HttpStatus.BAD_REQUEST);
    }
    
    @PostMapping(value="/updatematch")
	public ResponseEntity<?> updateMatch(@RequestBody MatchDetails details) {
		
		List<MatchDetails> flag=adminService.updateMatch(details);
		if(flag!=null) {
			return new ResponseEntity<Object>(flag,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Object>("Unable to update",HttpStatus.BAD_REQUEST);
		
	}
    
    @GetMapping(value="/teambidders")
    public ResponseEntity<?> noOfBidder(@RequestParam int teamId) {
    	long count=adminService.noOfBidders(teamId);
    	if(count==-1)
    		return new ResponseEntity<Object>("No Such team",HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity<Object>(count,HttpStatus.OK);
    }
    
    @GetMapping(value="/biddingpercent")
    public ResponseEntity<?> biddingPercentage(int matchId) {
    	double percent=adminService.biddingPercentage(matchId);
    	
    	return new ResponseEntity<Object>(percent+" "+(100-percent),HttpStatus.OK);
    }
    
    
    
	
	
	
}