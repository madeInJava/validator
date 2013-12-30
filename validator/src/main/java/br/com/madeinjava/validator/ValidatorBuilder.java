package br.com.madeinjava.validator;

/**
 * ValidatorBuilder.
 *
 * @param <T> tipo genérico
 * @author renan.paula
 */
public class ValidatorBuilder<T> {

	/** first validator. */
	private AbstractValidator<T> firstValidator;

	/** last validator. */
	private AbstractValidator<T> lastValidator;

	/**
	 * With validator.
	 *
	 * @param validator validator
	 * @return validator builder
	 */
	public ValidatorBuilder<T> withValidator(AbstractValidator<T> validator) {
		if (this.firstValidator == null) {
			this.firstValidator = validator;
		} else {
			this.lastValidator.setNextValidator(validator);
		}
		this.lastValidator = validator;
		return this;
	}

	/**
	 * Builds the.
	 *
	 * @return abstract validator
	 */
	public AbstractValidator<T> build() {
		return this.firstValidator;
	}
}
