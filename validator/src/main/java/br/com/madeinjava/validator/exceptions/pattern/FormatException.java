package br.com.madeinjava.validator.exceptions.pattern;

public class FormatException extends PatternException {

	private static final long serialVersionUID = 1L;

	public FormatException() {
		super("This value is not within the standard.");
	}
	
}
