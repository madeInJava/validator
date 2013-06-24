package br.com.madeInJava.validator.exceptions.general;

import br.com.madeInJava.validator.exceptions.ValidateException;

public class EmptyValueException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public EmptyValueException() {
		super("Empty value");
	}
}
