package br.com.madeInJava.validate.exceptions.general;

import br.com.madeInJava.validate.exceptions.ValidateException;

public class NullValueException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public NullValueException() {
		super("Null value");
	}

}
