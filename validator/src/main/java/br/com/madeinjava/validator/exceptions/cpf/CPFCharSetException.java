package br.com.madeinjava.validator.exceptions.cpf;

/**
 * CPFCharSetException.
 * 
 * @author renan.paula
 */
public class CPFCharSetException extends CPFException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo cPF char set exception.
	 */
	public CPFCharSetException() {
		super("The CPF can not be a string of equals digits.");
	}

}
