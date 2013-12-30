package br.com.madeinjava.validator.exceptions.limit;

/**
 * BeforeOfLimitException.
 *
 * @author renan.paula
 */
public class BeforeOfLimitException extends LimitException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo before of limit exception.
	 */
	public BeforeOfLimitException() {
		super("Value is less than threshold.");
	}

}
