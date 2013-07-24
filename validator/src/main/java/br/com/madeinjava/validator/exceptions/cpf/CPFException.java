package br.com.madeinjava.validator.exceptions.cpf;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class CPFException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public CPFException() {
		super();
	}

	public CPFException(String message) {
		super(message);
	}

}
