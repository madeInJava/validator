package br.com.madeInJava.validate.validators;

import br.com.madeInJava.validate.AbstractValidator;
import br.com.madeInJava.validate.exceptions.general.EmptyValueException;

public class NotEmptyValidator extends AbstractValidator<String> {

	@Override
	public void validate(String value) {
		if (value.toString().trim().isEmpty()) {
			throw new EmptyValueException();
		}
	}

}
