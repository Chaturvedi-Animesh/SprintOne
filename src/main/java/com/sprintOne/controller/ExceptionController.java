package com.sprintOne.controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sprintOne.customException.BidderNotFoundException;
import com.sprintOne.customException.EmptyLeaderboardException;
import com.sprintOne.customException.EmptyMatchDetailsException;
import com.sprintOne.customException.EmptyMatchListException;
import com.sprintOne.customException.ErrorMessage;
import com.sprintOne.customException.InvalidCredentialsException;
import com.sprintOne.customException.MatchNotFoundException;
import com.sprintOne.customException.NoSuchTeamException;
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
	@ExceptionHandler(NoSuchTeamException.class)
	public ResponseEntity<ErrorMessage> handleNoSuchTeamException(NoSuchTeamException n) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(n.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	@ExceptionHandler(EmptyMatchListException.class)
	public ResponseEntity<ErrorMessage> handleEmptyMatchListException(EmptyMatchListException e) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	@ExceptionHandler(EmptyMatchDetailsException.class)
	public ResponseEntity<ErrorMessage> handleEmptyMatchDetailsException(EmptyMatchDetailsException em) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(em.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	@ExceptionHandler(EmptyLeaderboardException.class)
	public ResponseEntity<ErrorMessage> handleEmptyLeaderboardException(EmptyLeaderboardException el) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.NOT_FOUND.value());
		error.setErrorMessage(el.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	}
	
}

