package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * NullValueException.
 * 
 * @author renan.paula
 */
public class NullValueException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo null value exception.
	 */
	public NullValueException() {
		super("Null value.");
	}

}
