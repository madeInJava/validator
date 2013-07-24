package br.com.madeinjava.validator.exceptions.range;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class OutsideOfRangeException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public OutsideOfRangeException() {
		super("Value outside of range.");
	}
	
}
