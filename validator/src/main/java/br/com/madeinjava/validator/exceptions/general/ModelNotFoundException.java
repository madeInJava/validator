package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class ModelNotFoundException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public ModelNotFoundException() {
		super("Model not found.");
	}

}
