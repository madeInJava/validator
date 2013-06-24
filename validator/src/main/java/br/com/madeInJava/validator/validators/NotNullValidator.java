package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.NullValueException;

public class NotNullValidator<T> extends AbstractValidator<T> {

	@Override
	public void validate(T value) {
		if (value == null) {
			throw new NullValueException();
		}
	}

}
