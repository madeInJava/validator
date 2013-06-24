package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.EmptyValueException;

public class NotEmptyValidator extends AbstractValidator<String> {

	@Override
	public void validate(String value) {
		if (value.toString().trim().isEmpty()) {
			throw new EmptyValueException();
		}
	}

}
