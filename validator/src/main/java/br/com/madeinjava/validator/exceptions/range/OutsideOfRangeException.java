package br.com.madeinjava.validator.exceptions.range;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * OutsideOfRangeException.
 * 
 * @author renan.paula
 */
public class OutsideOfRangeException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo outside of range exception.
	 */
	public OutsideOfRangeException() {
		super("Value outside of range.");
	}

}
