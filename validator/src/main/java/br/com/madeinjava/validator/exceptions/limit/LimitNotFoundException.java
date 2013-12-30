package br.com.madeinjava.validator.exceptions.limit;

/**
 * LimitNotFoundException.
 * 
 * @author renan.paula
 */
public class LimitNotFoundException extends LimitException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo limit not found exception.
	 */
	public LimitNotFoundException() {
		super("Limit not found.");
	}

}
