package com.mango.customer.error;

public class UserAlreadyExistedException extends RuntimeException {

	private String email;

	public UserAlreadyExistedException(String email) {
		this.email = email;
	}

	public void setName(String email) {
		this.email = email;
	}

	public String getMessage() {
		return "El usuario " + this.email + " ya se encontraba dado de alta en nuestra base de datos.";
	}
}
