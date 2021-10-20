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

import com.sprintOne.customException.BidderNotFoundException;
import com.sprintOne.customException.MatchNotFoundException;
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
	public ResponseEntity<Bidder> getBidder(@RequestParam int id) throws BidderNotFoundException{
		Bidder bidder = adminService.viewBidder(id);
		if(bidder==null) {
			throw new BidderNotFoundException("No Such bidder");
		}
		else
		return new ResponseEntity<>(bidder,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity cancelMatch(@RequestParam int matchId) throws MatchNotFoundException{
		boolean flag = adminService.cancelMatch(matchId);
		if(flag) {
			return new ResponseEntity("Match cancelled", HttpStatus.OK);
		}
		else {
			throw new MatchNotFoundException("Match with id" + matchId + "is not found");
		}
	}
	
	@PostMapping(value="/reschedule")
	public ResponseEntity rescheduleMatches(@RequestParam int matchId) {
		MatchDetails details=adminService.rescheduleMatches(matchId);
		if(details==null)
			return new ResponseEntity("unable to reschedule",HttpStatus.BAD_REQUEST);
		else
		return new ResponseEntity(details,HttpStatus.ACCEPTED);
	}
	
	@PostMapping(value = "/commence/tournament")
	public ResponseEntity commenceTournament(@RequestBody Tournament tournament) {
		boolean flag=adminService.commenceTournament(tournament);
		if(flag) {
			return new ResponseEntity("Tournament Commenced",HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity("Cannot Commence Tornament",HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping(value="/result")
	public ResponseEntity declareResult(@RequestParam Map<String, String> matchresult) {
		return null;
	}
    
    @PostMapping(value="/schedulematch")
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
    
    @PostMapping(value="/updatematch")
	public ResponseEntity updateMatch(@RequestBody MatchDetails details) {
		
		List<MatchDetails> flag=adminService.updateMatch(details);
		if(flag!=null) {
			return new ResponseEntity(flag,HttpStatus.OK);
		}
		else 
			return new ResponseEntity("Unable to update",HttpStatus.BAD_REQUEST);
		
	}
    
    @GetMapping(value="/teambidders")
    public ResponseEntity noOfBidder(@RequestParam int teamId) {
    	long count=adminService.noOfBidders(teamId);
    	if(count==-1)
    		return new ResponseEntity("No Such team",HttpStatus.BAD_REQUEST);
    	else return new ResponseEntity(count,HttpStatus.OK);
    }
       
    @GetMapping(value="/biddingpercent")
   public ResponseEntity biddingPercentage(int matchId) {
    	double percent = adminService.biddingPercentage(matchId);
    	if(percent == 0) {
    		return new ResponseEntity("Percentage not available",HttpStatus.BAD_REQUEST);
    	}
    	else
    		return new ResponseEntity(percent,HttpStatus.OK);
    } 
    
    
	
	
	
}