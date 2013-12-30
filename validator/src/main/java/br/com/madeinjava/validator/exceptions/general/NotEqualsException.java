package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * NotEqualsException.
 * 
 * @author renan.paula
 */
public class NotEqualsException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo not equals exception.
	 */
	public NotEqualsException() {
		super("Value not equals.");
	}

}
