package com.sprintOne.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sprintOne.customException.BidderNotFoundException;
import com.sprintOne.customException.ErrorMessage;
import com.sprintOne.customException.InvalidCredentialsException;
import com.sprintOne.customException.MatchNotFoundException;
import com.sprintOne.customException.UserAlreadyPresentException;




@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorMessage> handleInvalidCredentialsException(InvalidCredentialsException i) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(i.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<ErrorMessage> handleUserAlreadyPresentException(UserAlreadyPresentException u) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(u.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	@ExceptionHandler(BidderNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleBidderNotFoundException(BidderNotFoundException b) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(b.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	@ExceptionHandler(MatchNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleMatchNotFoundException(MatchNotFoundException m) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(m.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
}

