package br.com.madeinjava.validator.exceptions.cpf;

public class CPFCharSetException extends CPFException {

	private static final long serialVersionUID = 1L;

	public CPFCharSetException() {
		super("The CPF can not be a string of equals digits.");
	}

}
