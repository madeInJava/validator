package br.com.madeinjava.validator.exceptions.monetary;

public class MonetaryFormatException extends MonetaryException {

	private static final long serialVersionUID = 1L;

	public MonetaryFormatException() {
		super("This value does not have a valid format.");
	}

}
