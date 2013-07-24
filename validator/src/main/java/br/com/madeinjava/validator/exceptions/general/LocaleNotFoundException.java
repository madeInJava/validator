package br.com.madeinjava.validator.exceptions.general;

import br.com.madeinjava.validator.exceptions.ValidateException;

public class LocaleNotFoundException extends ValidateException {

	private static final long serialVersionUID = 1L;

	public LocaleNotFoundException() {
		super("Locale not found.");
	}

}
