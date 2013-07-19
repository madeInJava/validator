package br.com.madeInJava.validator.exceptions.monetary;

import br.com.madeInJava.validator.exceptions.ValidateException;

public class MonetaryException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public MonetaryException() {
		super();
	}

	public MonetaryException(String message) {
		super(message);
	}

}
