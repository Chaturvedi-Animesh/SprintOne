package com.sprintOne.customException;

public class EmptyTeamLeaderboardException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyTeamLeaderboardException(String message) {
		super(message);
	}
}
