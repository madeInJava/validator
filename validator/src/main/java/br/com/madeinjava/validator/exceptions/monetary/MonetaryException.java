package br.com.madeinjava.validator.exceptions.monetary;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class MonetaryException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public MonetaryException() {
		super();
	}

	public MonetaryException(String message) {
		super(message);
	}

}
