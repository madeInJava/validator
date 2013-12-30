package br.com.madeinjava.validator.exceptions.pattern;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * PatternException.
 * 
 * @author renan.paula
 */
public class PatternException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo pattern exception.
	 */
	public PatternException() {
		super();
	}

	/**
	 * Instancia um novo pattern exception.
	 * 
	 * @param message
	 *            message
	 */
	public PatternException(String message) {
		super(message);
	}
}
