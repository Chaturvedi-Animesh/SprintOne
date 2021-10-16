package com.sprintOne.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.model.Bidder;
import com.sprintOne.model.Leaderboard;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;
import com.sprintOne.service.BidderService;

@RestController
@RequestMapping("/bidder")
public class BidderController {

	@Autowired
	BidderService bidderService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerBidder(@RequestBody Bidder bidder, int bidderId) {
		boolean registerBidder = bidderService.registerBidder(bidder, bidderId);
		if(registerBidder == false) {
			return new ResponseEntity("User not registered",HttpStatus.BAD_REQUEST);
		}else
			return new ResponseEntity<>("Registration Successfull!", HttpStatus.OK);
	}
	
	@GetMapping("/login/{email}/{password}")
	public ResponseEntity<String> loginBidder(@PathVariable String email, @PathVariable String password) {
		if(bidderService.loginBidder(email, password) == false) {
			return new ResponseEntity("Login not successfull",HttpStatus.BAD_REQUEST);
		}else 
			
			return new ResponseEntity<>("Login Successfull!", HttpStatus.OK);
	}
	
	@GetMapping("/bidderLeaderBoard/{bidderId}")
	public ResponseEntity<List<Leaderboard>> viewLeaderboard(@PathVariable int bidderId){
		List<Leaderboard> leadList = bidderService.viewLeaderboard(bidderId);
		if(leadList==null) {
			return new ResponseEntity("LeaderBoard is empty", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<>(leadList, HttpStatus.OK);
		
	}
	
	@GetMapping("/teamLeaderBoard")
	public ResponseEntity<List<TeamPointsTable>> viewPointsTable(){
		List<TeamPointsTable> teamList = bidderService.viewPointsTable();
		if(teamList == null) {
			return new ResponseEntity("Team LeaderBoard is empty", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<>(teamList, HttpStatus.OK);
		
	}
	
	@GetMapping("/selectTeam/{teamId}")
	public ResponseEntity<TeamDetails> selectTeam(@PathVariable int teamId){
		TeamDetails td = bidderService.selectTeam(teamId);
		if(td == null) {
			return new ResponseEntity("Team Details not available", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity<>(td, HttpStatus.OK);
	}
	
	@PutMapping("/changeTeam")
	public ResponseEntity<TeamDetails> changeTeam(@RequestBody TeamDetails teamdetails){
		String str = bidderService.changeTeam(teamdetails);
		if(str == null) {
			return new ResponseEntity("Team Details not available", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity(str, HttpStatus.OK);
	}
}
