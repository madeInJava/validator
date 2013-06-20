package br.com.madeInJava.validate.exceptions.general;

import br.com.madeInJava.validate.exceptions.ValidateException;

public class EmptyValueException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public EmptyValueException() {
		super("Empty value");
	}
}
