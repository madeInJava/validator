package br.com.madeinjava.validator.exceptions.pattern;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class PatternException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public PatternException() {
		super();
	}

	public PatternException(String message) {
		super(message);
	}
}
