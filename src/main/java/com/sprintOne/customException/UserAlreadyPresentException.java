package com.sprintOne.customException;

public class UserAlreadyPresentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyPresentException(String message) {
		super(message);
	}
}
