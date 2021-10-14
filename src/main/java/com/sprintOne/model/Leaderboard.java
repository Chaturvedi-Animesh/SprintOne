package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Leaderboard {
	
	@Id
	private int bidder_id;
	private String bidder_name;
	private int bidder_points;
	private int bids_participated;
	private int bids_won;
	private float percentile;
	
	public Leaderboard() {
		
	}
	
	
	public Leaderboard(int bidder_id, String bidder_name, int bidder_points, int bids_participated, 
			int bids_won, float percentile) {
		super();
		this.bidder_id = bidder_id;
		this.bidder_name = bidder_name;
		this.bidder_points = bidder_points;
		this.bids_participated = bids_participated;
		this.bids_won = bids_won;
		this.percentile = percentile;
	}


	public int getBidder_id() {
		return bidder_id;
	}


	public void setBidder_id(int bidder_id) {
		this.bidder_id = bidder_id;
	}


	public String getBidder_name() {
		return bidder_name;
	}


	public void setBidder_name(String bidder_name) {
		this.bidder_name = bidder_name;
	}


	public int getBidder_points() {
		return bidder_points;
	}


	public void setBidder_points(int bidder_points) {
		this.bidder_points = bidder_points;
	}


	public int getBids_participated() {
		return bids_participated;
	}


	public void setBids_participated(int bids_participated) {
		this.bids_participated = bids_participated;
	}


	public int getBids_won() {
		return bids_won;
	}


	public void setBids_won(int bids_won) {
		this.bids_won = bids_won;
	}


	public float getPercentile() {
		return percentile;
	}


	public void setPercentile(float percentile) {
		this.percentile = percentile;
	}
	
	
	
	
	
	

}
