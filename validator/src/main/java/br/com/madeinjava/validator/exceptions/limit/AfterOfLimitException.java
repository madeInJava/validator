package br.com.madeinjava.validator.exceptions.limit;

/**
 * AfterOfLimitException.
 * 
 * @author renan.paula
 */
public class AfterOfLimitException extends LimitException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo after of limit exception.
	 */
	public AfterOfLimitException() {
		super("Value is greater than the threshold.");
	}

}
