package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.limit.BeforeOfLimitException;
import br.com.madeInJava.validator.exceptions.limit.LimitNotFoundException;

public class AfterValidator<T extends Comparable<T>> extends AbstractValidator<T> {

	private T limit;

	public AfterValidator() {
		super();
	}

	public AfterValidator(T limit) {
		this();
		this.limit = limit;
	}

	public T getLimit() {
		return limit;
	}

	public void setLimit(T limit) {
		this.limit = limit;
	}

	@Override
	protected void validate(T value) {
		if (this.limit == null) {
			throw new LimitNotFoundException();
		}

		if (value.compareTo(this.limit) < 1) {
			throw new BeforeOfLimitException();
		}
	}

}
