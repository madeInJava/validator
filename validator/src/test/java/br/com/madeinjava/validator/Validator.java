package br.com.madeinjava.validator;

import br.com.madeinjava.validator.validators.NotEmptyValidator;
import br.com.madeinjava.validator.validators.NotNullValidator;

public class Validator {

	private static AbstractValidator<String> notNullAndNotEmptyValidator;

	public AbstractValidator<String> notNullAndNotEmptyValidator() {
		if (notNullAndNotEmptyValidator == null) {
			notNullAndNotEmptyValidator = new ValidatorBuilder<String>()
					.withValidator(new NotNullValidator<String>())
					.withValidator(new NotEmptyValidator())
					.build();
		}
		return notNullAndNotEmptyValidator;
	}
	
}
