package br.com.madeinjava.validator.exceptions.limit;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * LimitException.
 * 
 * @author renan.paula
 */
public class LimitException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo limit exception.
	 */
	public LimitException() {
		super();
	}

	/**
	 * Instancia um novo limit exception.
	 * 
	 * @param message
	 *            message
	 */
	public LimitException(String message) {
		super(message);
	}

}
