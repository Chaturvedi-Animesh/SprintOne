package com.sprintOne.customException;

public class EmptyLeaderboardException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyLeaderboardException(String message) {
		super(message);
	}
}
