package br.com.madeInJava.validator.exceptions.limit;

public class AfterOfLimitException extends LimitException {

	private static final long serialVersionUID = 1L;

	public AfterOfLimitException() {
		super("Value is greater than the threshold.");
	}

}
