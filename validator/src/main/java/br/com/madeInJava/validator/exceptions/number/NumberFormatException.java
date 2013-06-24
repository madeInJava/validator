package br.com.madeInJava.validator.exceptions.number;

public class NumberFormatException extends NumberException {

	private static final long serialVersionUID = 1L;

	public NumberFormatException() {
		super("Not a number");
	}
}
