package br.com.madeInJava.validate.exceptions.email;

import br.com.madeInJava.validate.exceptions.ValidateException;

public class EmailException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public EmailException() {
		super();
	}

	public EmailException(String message) {
		super(message);
	}
	
}
