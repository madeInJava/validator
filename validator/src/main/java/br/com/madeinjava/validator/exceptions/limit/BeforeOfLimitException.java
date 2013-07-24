package br.com.madeinjava.validator.exceptions.limit;

public class BeforeOfLimitException extends LimitException {

	private static final long serialVersionUID = 1L;
	
	public BeforeOfLimitException() {
		super("Value is less than threshold.");
	}

}
