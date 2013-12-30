package br.com.madeinjava.validator.exceptions.interval;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * IntervalException.
 * 
 * @author renan.paula
 */
public class IntervalException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo interval exception.
	 */
	public IntervalException() {
		super();
	}

	/**
	 * Instancia um novo interval exception.
	 * 
	 * @param message
	 *            message
	 */
	public IntervalException(String message) {
		super(message);
	}

}
