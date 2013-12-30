package br.com.madeinjava.validator.exceptions.email;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * EmailException.
 * 
 * @author renan.paula
 */
public class EmailException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo email exception.
	 */
	public EmailException() {
		super();
	}

	/**
	 * Instancia um novo email exception.
	 * 
	 * @param message
	 *            message
	 */
	public EmailException(String message) {
		super(message);
	}

}
