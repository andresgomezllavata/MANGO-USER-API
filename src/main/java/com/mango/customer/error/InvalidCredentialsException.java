package com.mango.customer.error;

public class InvalidCredentialsException extends RuntimeException {

	public InvalidCredentialsException() {
	}

	public String getMessage() {
		return "Credenciales invalidas.";
	}

}
