package com.mango.customer.controller;

import com.mango.customer.error.InvalidCredentialsException;
import com.mango.customer.error.UserAlreadyExistedException;
import com.mango.customer.error.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<Object> invalidCredentialsException(InvalidCredentialsException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(value = UserAlreadyExistedException.class)
	public ResponseEntity<Object> userAlreadyExistedException(UserAlreadyExistedException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.CONFLICT);
	}
}
