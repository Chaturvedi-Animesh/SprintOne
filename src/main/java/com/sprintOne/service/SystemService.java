package com.sprintOne.service;

import java.util.List;

import com.sprintOne.customException.EmptyMatchDetailsException;
import com.sprintOne.customException.EmptyMatchListException;
import com.sprintOne.customException.NoSuchTeamException;
import com.sprintOne.model.MatchDetails;
import com.sprintOne.model.TeamDetails;
import com.sprintOne.model.TeamPointsTable;

public interface SystemService {

	List<MatchDetails> getMatchDetails() throws EmptyMatchListException;

	List<MatchDetails> getAllMatchDetails() throws EmptyMatchDetailsException;

	TeamDetails getTeamDetails(int id) throws NoSuchTeamException;

	TeamPointsTable getTeamStat(int id) throws NoSuchTeamException;

	TeamPointsTable displayteamstats(int id);

}