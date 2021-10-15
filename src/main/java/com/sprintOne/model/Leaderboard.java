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
	private int bidderId;
	
	@OneToOne
	@JoinColumn(name = "name")
	@Column(name = "bidder_name")
	private Bidder biddername;
	
	@OneToOne
	@JoinColumn(name = "points")
	@Column(name = "bidder_points")
	private Bidder bidderpoints;
	
	@JoinColumn(name = "number_of_teams")
	@Column(name = "bids_participated")
	private Tournament bidsparticipated;
	
	@JoinColumn(name = "matches_won")
	@Column(name = "bids_won")
	private TeamPointsTable bidswon;
	
	@JoinColumn(name = "matches_played")
	@Column(name = "percentile")
	private TeamPointsTable percentile;
	
	public Leaderboard() {
		
	}

	public Leaderboard(int bidderId, Bidder biddername, Bidder bidderpoints, Tournament bidsparticipated,
			TeamPointsTable bidswon, TeamPointsTable percentile) {
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

	public Tournament getBidsparticipated() {
		return bidsparticipated;
	}

	public void setBidsparticipated(Tournament bidsparticipated) {
		this.bidsparticipated = bidsparticipated;
	}

	public TeamPointsTable getBidswon() {
		return bidswon;
	}

	public void setBidswon(TeamPointsTable bidswon) {
		this.bidswon = bidswon;
	}

	public TeamPointsTable getPercentile() {
		return percentile;
	}

	public void setPercentile(TeamPointsTable percentile) {
		this.percentile = percentile;
	}

	
    
	
	
}
	