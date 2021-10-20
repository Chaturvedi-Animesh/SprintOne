package com.sprintOne.service;

import java.util.List;

import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

public interface SystemService {

	List<MatchDetails> getMatchDetails();

	List<MatchDetails> getAllMatchDetails();

	TeamDetails getTeamDetails(int id);

	TeamPointsTable getTeamStat(int id);

	TeamPointsTable displayteamstats(int id);

}