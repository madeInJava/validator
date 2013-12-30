package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * InvalidArgumentException.
 * 
 * @author renan.paula
 */
public class InvalidArgumentException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo invalid argument exception.
	 */
	public InvalidArgumentException() {
		super("Argument invalid.");
	}

}
