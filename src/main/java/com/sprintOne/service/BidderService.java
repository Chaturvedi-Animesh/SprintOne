package com.sprintOne.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprintOne.dao.BidderDao;
import com.sprintOne.model.Bidder;

@Service
public class BidderService {
	
	@Autowired
	BidderDao bidderDao;
	
	
	
	public void registerBidder(Bidder bidder) {
		
	bidderDao.save(bidder);
	}
	
	public boolean loginBidder(String email, String password) {
		
		List<Bidder> bidderList=bidderDao.findAll();
		
		for(Bidder bidder:bidderList) {
			if(bidder.getEmail().equals(email) && bidder.getPassword().equals(password)){
				return true;
			}
		}
		
		return false;
	}

}
