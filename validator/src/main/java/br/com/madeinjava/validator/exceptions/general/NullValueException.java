package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class NullValueException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public NullValueException() {
		super("Null value.");
	}

}