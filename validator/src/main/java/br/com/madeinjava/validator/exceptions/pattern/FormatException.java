package br.com.madeinjava.validator.exceptions.pattern;

/**
 * FormatException.
 * 
 * @author renan.paula
 */
public class FormatException extends PatternException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo format exception.
	 */
	public FormatException() {
		super("This value is not within the standard.");
	}

}
