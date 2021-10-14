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
	
	@JoinColumn(name = "number_of_teams")
	@Column(name = "bids_participated")
	private Tournament bidsparticipated;
	
	@JoinColumn(name = "matches_won")
	@Column(name = "bids_won")
	private TeamPoints_Table bidswon;
	
	@JoinColumn(name = "matches_played")
	@Column(name = "percentile")
	private TeamPoints_Table percentile;
	
	public Leaderboard() {
		
	}

	public Leaderboard(int bidder_id, Bidder biddername, Bidder bidderpoints, Tournament bidsparticipated,
			TeamPoints_Table bidswon, TeamPoints_Table percentile) {
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

	public Tournament getBidsparticipated() {
		return bidsparticipated;
	}

	public void setBidsparticipated(Tournament bidsparticipated) {
		this.bidsparticipated = bidsparticipated;
	}

	public TeamPoints_Table getBidswon() {
		return bidswon;
	}

	public void setBidswon(TeamPoints_Table bidswon) {
		this.bidswon = bidswon;
	}

	public TeamPoints_Table getPercentile() {
		return percentile;
	}

	public void setPercentile(TeamPoints_Table percentile) {
		this.percentile = percentile;
	}

	
    
	
	
}
	