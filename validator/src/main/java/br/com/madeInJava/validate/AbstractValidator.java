package br.com.madeInJava.validate;

import br.com.madeInJava.validate.exceptions.ValidateException;

public abstract class AbstractValidator<T> {

	private AbstractValidator<T> nexValidator;

	public void nextValidator(AbstractValidator<T> validator) {
		this.nexValidator = validator;
	}

	public void doValidation(T value) {
		this.validate(value);

		if (this.nexValidator != null)
			this.nexValidator.doValidation(value);
	}

	public boolean isValid(T value) {
		try {
			this.doValidation(value);
			return true;
		} catch (ValidateException e) {
			return false;
		}
	}

	protected abstract void validate(T value);
}
