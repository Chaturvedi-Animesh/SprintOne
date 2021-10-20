package com.sprintOne.customException;

public class EmptyMatchListException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyMatchListException(String message) {
		super(message);
	}
}
