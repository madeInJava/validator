package br.com.madeinjava.validator.exceptions.cpf;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * CPFException.
 * 
 * @author renan.paula
 */
public class CPFException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo cPF exception.
	 */
	public CPFException() {
		super();
	}

	/**
	 * Instancia um novo cPF exception.
	 * 
	 * @param message
	 *            message
	 */
	public CPFException(String message) {
		super(message);
	}

}
