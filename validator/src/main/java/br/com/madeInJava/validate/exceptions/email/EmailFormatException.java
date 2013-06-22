package br.com.madeInJava.validate.exceptions.email;

public class EmailFormatException extends EmailException {

	private static final long serialVersionUID = 1L;

	public EmailFormatException() {
		super("E-mail does not match the proper format");
	}
}
