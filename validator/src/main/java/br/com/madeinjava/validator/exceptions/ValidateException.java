package br.com.madeinjava.validator.exceptions;

/**
 * ValidateException.
 *
 * @author renan.paula
 */
public class ValidateException extends RuntimeException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo validate exception.
	 */
	public ValidateException() {
		super();
	}

	/**
	 * Instancia um novo validate exception.
	 *
	 * @param message message
	 */
	public ValidateException(String message) {
		super(message);
	}

}
