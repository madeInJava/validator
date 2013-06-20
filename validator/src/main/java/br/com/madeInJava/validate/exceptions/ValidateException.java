package br.com.madeInJava.validate.exceptions;

public class ValidateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ValidateException() {
		super();
	}

	public ValidateException(String message) {
		super(message);
	}
	
}
