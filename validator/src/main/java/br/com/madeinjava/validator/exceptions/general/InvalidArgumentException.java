package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class InvalidArgumentException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public InvalidArgumentException() {
		super("Argument invalid.");
	}

}
