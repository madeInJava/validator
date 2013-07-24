package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class EmptyValueException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public EmptyValueException() {
		super("Empty value.");
	}
}
