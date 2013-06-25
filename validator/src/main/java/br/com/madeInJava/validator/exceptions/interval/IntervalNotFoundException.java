package br.com.madeInJava.validator.exceptions.interval;

public class IntervalNotFoundException extends IntervalException {

	private static final long serialVersionUID = 1L;

	public IntervalNotFoundException() {
		super("Interval not found.");
	}

}
