package com.sprintOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprintOne.model.Bidder;
import com.sprintOne.model.Leaderboard;
import com.sprintOne.service.BidderService;

@RestController
@RequestMapping("/bidder")
public class BidderController {

	@Autowired
	BidderService bidderService;
	
	@PostMapping("/register")
	public void registerBidder(@RequestBody Bidder bidder) {
		this.bidderService.registerBidder(bidder);
	}
	
	@GetMapping("/bidderLeaderBoard/{bidderId}")
	public List<Leaderboard> viewLeaderboard(@PathVariable int bidderId){
		return this.bidderService.viewLeaderboard(bidderId);
	}
}
