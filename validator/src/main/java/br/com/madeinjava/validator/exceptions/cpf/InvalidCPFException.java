package br.com.madeinjava.validator.exceptions.cpf;

/**
 * InvalidCPFException.
 * 
 * @author renan.paula
 */
public class InvalidCPFException extends CPFException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo invalid cpf exception.
	 */
	public InvalidCPFException() {
		super("CPF Invalid.");
	}

}
