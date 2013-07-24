package br.com.madeinjava.validator.exceptions.email;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class EmailException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public EmailException() {
		super();
	}

	public EmailException(String message) {
		super(message);
	}
	
}
