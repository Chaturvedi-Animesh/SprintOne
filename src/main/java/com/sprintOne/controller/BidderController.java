package com.sprintOne.controller;

import java.io.IOException;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.customException.EmptyLeaderboardException;
import com.sprintOne.customException.EmptyTeamLeaderboardException;
import com.sprintOne.customException.InvalidCredentialsException;
import com.sprintOne.customException.NoSuchTeamException;
import com.sprintOne.customException.UserAlreadyPresentException;
import com.sprintOne.model.Bidder;
import com.sprintOne.model.Leaderboard;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;
import com.sprintOne.service.BiddderService;

import com.sprintOne.service.BidderServiceImpl;

@RestController
@RequestMapping(value="/bidder")
public class BidderController {

	@Autowired
	BiddderService bidderService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerBidder(@RequestBody Bidder bidder) throws UserAlreadyPresentException{
		boolean registerBidder = bidderService.registerBidder(bidder);
		if(registerBidder == false) {
			throw new UserAlreadyPresentException("User Already Present");
		}else
			return new ResponseEntity<>("Registration Successfull!", HttpStatus.OK);
	}

	
	@GetMapping("/login")
	public ResponseEntity<String> loginBidder(@RequestParam Map<String, String> userpass) throws IOException, InvalidCredentialsException{
			String email=userpass.get("email");
			String password=userpass.get("password");
			if(email==null||password==null) {
				throw new InvalidCredentialsException("Invalid username and password"); 
			}
			if(bidderService.loginBidder(email, password) == false) {
				throw new InvalidCredentialsException("Invalid username and password");
			}else {
				return new ResponseEntity<>("Login succesfull!", HttpStatus.OK);
			}	
	}
	
	@GetMapping("/bidderLeaderBoard/{bidderId}")
	public ResponseEntity<List<Leaderboard>> viewLeaderboard(@PathVariable int bidderId) throws EmptyLeaderboardException{
	    List<Leaderboard> leadList = bidderService.viewLeaderboard(bidderId);
		if(leadList.isEmpty()) {
			throw new EmptyLeaderboardException("LeaderBoard is empty");
		}
		else
			return new ResponseEntity<>(leadList, HttpStatus.OK);
		
	}
	
	@GetMapping("/teamLeaderBoard")
	public ResponseEntity<List<TeamPointsTable>> viewPointsTable() throws EmptyTeamLeaderboardException{
		List<TeamPointsTable> teamList = bidderService.viewPointsTable();
		if(teamList.isEmpty()) {
            throw new EmptyTeamLeaderboardException("Team LeaderBoard is empty");  
		}
		else
			return new ResponseEntity<>(teamList, HttpStatus.OK);
		
	}
	
	@GetMapping("/selectTeam/{teamId}")
	public ResponseEntity<TeamDetails> selectTeam(@PathVariable int teamId) throws NoSuchTeamException{
		TeamDetails td = bidderService.selectTeam(teamId);
		if(td == null) {
			throw new NoSuchTeamException("No Such Team");
		}
		else
			return new ResponseEntity<>(td, HttpStatus.OK);
	}
	
	@PutMapping("/changeTeam")
	public ResponseEntity<String> changeTeam(@RequestParam int userId){
		String str = bidderService.changeTeam(userId);
		if(str == null) {
 		return new ResponseEntity("Team Details not available", HttpStatus.BAD_REQUEST);
		}
		else
			return new ResponseEntity(str, HttpStatus.OK);
	}
}