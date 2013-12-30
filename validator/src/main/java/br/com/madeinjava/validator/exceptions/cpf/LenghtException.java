package br.com.madeinjava.validator.exceptions.cpf;

/**
 * LenghtException.
 * 
 * @author renan.paula
 */
public class LenghtException extends CPFException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo lenght exception.
	 */
	public LenghtException() {
		super("The size is invalid. CPFs contains 11 or 14 digits.");
	}

}
