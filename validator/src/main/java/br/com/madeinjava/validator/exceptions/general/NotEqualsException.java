package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class NotEqualsException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public NotEqualsException() {
		super("Value not equals.");
	}

}
