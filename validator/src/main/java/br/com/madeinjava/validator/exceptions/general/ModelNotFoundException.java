package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

/**
 * ModelNotFoundException.
 * 
 * @author renan.paula
 */
public class ModelNotFoundException extends ValidateException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo model not found exception.
	 */
	public ModelNotFoundException() {
		super("Model not found.");
	}

}
