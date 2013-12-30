package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * EmptyValueException.
 * 
 * @author renan.paula
 */
public class EmptyValueException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo empty value exception.
	 */
	public EmptyValueException() {
		super("Empty value.");
	}
}
