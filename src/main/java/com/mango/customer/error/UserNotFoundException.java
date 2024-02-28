package com.mango.customer.error;

public class UserNotFoundException extends RuntimeException {
	private String email;

	public UserNotFoundException(String email) {
		this.email = email;
	}

	public void setName(String email) {
		this.email = email;
	}

	public String getMessage() {
		return "El usuario " + this.email + " no se ha encontrado en nuestra base de datos.";
	}

}
