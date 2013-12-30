package br.com.madeinjava.validator.exceptions.monetary;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * MonetaryException.
 *
 * @author renan.paula
 */
public class MonetaryException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo monetary exception.
	 */
	public MonetaryException() {
		super();
	}

	/**
	 * Instancia um novo monetary exception.
	 *
	 * @param message message
	 */
	public MonetaryException(String message) {
		super(message);
	}

}
