package br.com.madeInJava.validate.validators;

import java.util.regex.Pattern;

import br.com.madeInJava.validate.AbstractValidator;
import br.com.madeInJava.validate.exceptions.number.NumberFormatException;

public class NumberValidator extends AbstractValidator<String> {

	private static final Pattern patten = Pattern.compile("^[0-9]+$");

	@Override
	public void validate(String value) {
		if (!patten.matcher(value).matches()) {
			throw new NumberFormatException();
		}
	}

}
