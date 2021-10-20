package com.sprintOne.customException;

public class NoSuchTeamException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchTeamException(String message) {
		super(message);
	}
}
