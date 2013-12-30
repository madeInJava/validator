package br.com.madeinjava.validator.exceptions.interval;

/**
 * IntervalNotFoundException.
 * 
 * @author renan.paula
 */
public class IntervalNotFoundException extends IntervalException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo interval not found exception.
	 */
	public IntervalNotFoundException() {
		super("Interval not found.");
	}

}
