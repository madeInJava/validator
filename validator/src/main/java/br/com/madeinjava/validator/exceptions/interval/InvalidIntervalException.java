package br.com.madeinjava.validator.exceptions.interval;

/**
 * InvalidIntervalException.
 * 
 * @author renan.paula
 */
public class InvalidIntervalException extends IntervalException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo invalid interval exception.
	 */
	public InvalidIntervalException() {
		super("Invalid range. The initial value must be less than or equal to the final value.");
	}

}
