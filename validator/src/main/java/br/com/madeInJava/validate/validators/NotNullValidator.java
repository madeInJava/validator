package br.com.madeInJava.validate.validators;

import br.com.madeInJava.validate.AbstractValidator;
import br.com.madeInJava.validate.exceptions.general.NullValueException;

public class NotNullValidator<T> extends AbstractValidator<T> {

	@Override
	public void validate(T value) {
		if (value == null) {
			throw new NullValueException();
		}
	}

}
