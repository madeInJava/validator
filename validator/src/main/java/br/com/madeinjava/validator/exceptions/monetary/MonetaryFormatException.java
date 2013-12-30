package br.com.madeinjava.validator.exceptions.monetary;

/**
 * MonetaryFormatException.
 * 
 * @author renan.paula
 */
public class MonetaryFormatException extends MonetaryException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo monetary format exception.
	 */
	public MonetaryFormatException() {
		super("This value does not have a valid format.");
	}

}
