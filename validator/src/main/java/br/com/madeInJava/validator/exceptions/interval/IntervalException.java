package br.com.madeInJava.validator.exceptions.interval;

import br.com.madeInJava.validator.exceptions.ValidateException;

public class IntervalException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public IntervalException() {
		super();
	}

	public IntervalException(String message) {
		super(message);
	}

}
