package com.sprintOne.customException;

public class MatchNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MatchNotFoundException(String message) {
		super(message);
	}
}
