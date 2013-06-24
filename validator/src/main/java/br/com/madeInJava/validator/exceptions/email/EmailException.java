package br.com.madeInJava.validator.exceptions.email;

import br.com.madeInJava.validator.exceptions.ValidateException;

public class EmailException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public EmailException() {
		super();
	}

	public EmailException(String message) {
		super(message);
	}
	
}
