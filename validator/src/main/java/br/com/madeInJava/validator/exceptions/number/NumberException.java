package br.com.madeInJava.validator.exceptions.number;

import br.com.madeInJava.validator.exceptions.ValidateException;

public class NumberException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public NumberException() {
		super();
	}

	public NumberException(String message) {
		super(message);
	}
}
