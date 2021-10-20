package com.sprintOne.customException;

public class EmptyMatchDetailsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyMatchDetailsException(String message) {
		super(message);
	}
}
