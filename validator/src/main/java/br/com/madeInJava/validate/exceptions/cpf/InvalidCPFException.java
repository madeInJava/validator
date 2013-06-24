package br.com.madeInJava.validate.exceptions.cpf;

public class InvalidCPFException extends CPFException {

	private static final long serialVersionUID = 1L;

	public InvalidCPFException() {
		super("CPF Invalid.");
	}

}
