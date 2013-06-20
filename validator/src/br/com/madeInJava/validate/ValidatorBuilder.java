package br.com.madeInJava.validate;

public class ValidatorBuilder<T> {
	
	private AbstractValidator<T> firstValidator;
	
	private AbstractValidator<T> lastValidator;

	public ValidatorBuilder<T> withValidator(AbstractValidator<T> validator) {
		if (this.firstValidator == null) {
			this.firstValidator = validator;
		} else {
			this.lastValidator.nextValidator(validator);
		}
		this.lastValidator = validator;
		return this;
	}

	public AbstractValidator<T> build() {
		return this.firstValidator;
	}
}
