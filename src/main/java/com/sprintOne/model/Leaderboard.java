package com.sprintOne.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Leaderboard")

public class Leaderboard {
	
	@Id
	private int bidderId;
	
	private String biddername;

	private int bidderpoints;
	
	
	private int bidsparticipated;
	
	
	private int bidswon;
	
	
	private double percentile;
	
	public Leaderboard() {
		
	}

	public Leaderboard(int bidderId, String biddername, int bidderpoints, int bidsparticipated,
			int bidswon, double percentile) {
		super();
		this.bidderId = bidderId;
		this.biddername = biddername;
		this.bidderpoints = bidderpoints;
		this.bidsparticipated = bidsparticipated;
		this.bidswon = bidswon;
		this.percentile = percentile;
	}

	public int getBidderId() {
		return bidderId;
	}

	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}

	public String getBiddername() {
		return biddername;
	}

	public void setBiddername(String biddername) {
		this.biddername = biddername;
	}

	public int getBidderpoints() {
		return bidderpoints;
	}

	public void setBidderpoints(int bidderpoints) {
		this.bidderpoints = bidderpoints;
	}

	public int getBidsparticipated() {
		return bidsparticipated;
	}

	public void setBidsparticipated(int bidsparticipated) {
		this.bidsparticipated = bidsparticipated;
	}

	public int getBidswon() {
		return bidswon;
	}

	public void setBidswon(int bidswon) {
		this.bidswon = bidswon;
	}

	public double getPercentile() {
		return percentile;
	}

	public void setPercentile() {
		if(this.bidsparticipated!=0 && this.bidswon!=0)
		this.percentile=((this.bidsparticipated-this.bidswon)/this.bidsparticipated)*100;
		else
			this.percentile=0.0;
	}

	
    
	
	
}
	