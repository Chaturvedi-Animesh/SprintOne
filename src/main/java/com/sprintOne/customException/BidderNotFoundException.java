package com.sprintOne.customException;

public class BidderNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BidderNotFoundException(String message) {
		super(message);
	}
}
