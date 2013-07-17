package br.com.madeInJava.validator.exceptions.limit;


public class LimitNotFoundException extends LimitException {

	private static final long serialVersionUID = 1L;

	public LimitNotFoundException() {
		super("Limit not found.");
	}

}
