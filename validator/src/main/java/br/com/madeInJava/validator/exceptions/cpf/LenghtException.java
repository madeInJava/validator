package br.com.madeInJava.validator.exceptions.cpf;

public class LenghtException extends CPFException{

	private static final long serialVersionUID = 1L;

	public LenghtException() {
		super("The size is invalid. CPFs contains 11 or 14 digits.");
	}
	
}
