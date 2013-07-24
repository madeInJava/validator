package br.com.madeinjava.validator.exceptions.email;

public class EmailFormatException extends EmailException {

	private static final long serialVersionUID = 1L;

	public EmailFormatException() {
		super("E-mail does not match the proper format.");
	}
}
