package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * LocaleNotFoundException.
 * 
 * @author renan.paula
 */
public class LocaleNotFoundException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo locale not found exception.
	 */
	public LocaleNotFoundException() {
		super("Locale not found.");
	}

}
