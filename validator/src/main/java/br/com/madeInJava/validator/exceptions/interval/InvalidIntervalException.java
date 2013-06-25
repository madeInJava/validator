package br.com.madeInJava.validator.exceptions.interval;

public class InvalidIntervalException extends IntervalException {

	private static final long serialVersionUID = 1L;

	public InvalidIntervalException() {
		super("Invalid range. The initial value must be less than or equal to the final value..");
	}

}
