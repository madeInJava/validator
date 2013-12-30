package br.com.madeinjava.validator.exceptions.email;

/**
 * EmailFormatException.
 * 
 * @author renan.paula
 */
public class EmailFormatException extends EmailException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo email format exception.
	 */
	public EmailFormatException() {
		super("E-mail does not match the proper format.");
	}
}
