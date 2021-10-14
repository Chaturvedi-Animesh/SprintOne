package com.sprintOne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Leaderboard")

public class Leaderboard {
	
	@Id
	@Column(name = "bidder_id")
	private int bidder_id;
	
	@OneToOne
	@JoinColumn(name = "name")
	@Column(name = "bidder_name")
	private Bidder biddername;
	
	@OneToOne
	@JoinColumn(name = "points")
	@Column(name = "bidder_points")
	private Bidder bidderpoints;
	
	@Column(name = "bids_participated")
	private String bidsparticipated;
	
	@Column(name = "bids_won")
	private int bidswon;
	
	@Column(name = "percentile")
	private float percentile;
	
	public Leaderboard() {
		
	}

	public Leaderboard(int bidder_id, Bidder biddername, Bidder bidderpoints, String bidsparticipated, int bidswon,
			float percentile) {
		super();
		this.bidder_id = bidder_id;
		this.biddername = biddername;
		this.bidderpoints = bidderpoints;
		this.bidsparticipated = bidsparticipated;
		this.bidswon = bidswon;
		this.percentile = percentile;
	}

	public int getBidder_id() {
		return bidder_id;
	}

	public void setBidder_id(int bidder_id) {
		this.bidder_id = bidder_id;
	}

	public Bidder getBiddername() {
		return biddername;
	}

	public void setBiddername(Bidder biddername) {
		this.biddername = biddername;
	}

	public Bidder getBidderpoints() {
		return bidderpoints;
	}

	public void setBidderpoints(Bidder bidderpoints) {
		this.bidderpoints = bidderpoints;
	}

	public String getBidsparticipated() {
		return bidsparticipated;
	}

	public void setBidsparticipated(String bidsparticipated) {
		this.bidsparticipated = bidsparticipated;
	}

	public int getBidswon() {
		return bidswon;
	}

	public void setBidswon(int bidswon) {
		this.bidswon = bidswon;
	}

	public float getPercentile() {
		return percentile;
	}

	public void setPercentile(float percentile) {
		this.percentile = percentile;
	}
	
    
	
	
}
	