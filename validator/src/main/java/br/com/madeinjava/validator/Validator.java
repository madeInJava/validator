package br.com.madeinjava.validator;

import br.com.madeinjava.validator.validators.NotEmptyValidator;
import br.com.madeinjava.validator.validators.NotNullValidator;

/**
 * Validator.
 *
 * @author renan.paula
 */
public abstract class Validator {

	/** not null and not empty validator. */
	private static AbstractValidator<String> notNullAndNotEmptyValidator;

	/**
	 * Not null and not empty validator.
	 *
	 * @return abstract validator
	 */
	public static AbstractValidator<String> notNullAndNotEmptyValidator() {
		if (notNullAndNotEmptyValidator == null) {
			notNullAndNotEmptyValidator = new ValidatorBuilder<String>()
					.withValidator(new NotNullValidator<String>())
					.withValidator(new NotEmptyValidator())
					.build();
		}
		return notNullAndNotEmptyValidator;
	}

}
