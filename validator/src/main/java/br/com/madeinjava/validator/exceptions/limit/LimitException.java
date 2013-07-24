package br.com.madeinjava.validator.exceptions.limit;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class LimitException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public LimitException() {
		super();
	}

	public LimitException(String message) {
		super(message);
	}

}
