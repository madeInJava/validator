package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.limit.AfterOfLimitException;
import br.com.madeInJava.validator.exceptions.limit.LimitNotFoundException;

public class BeforeValidator<T extends Comparable<T>> extends AbstractValidator<T> {

	private T limit;

	public BeforeValidator() {
		super();
	}

	public BeforeValidator(T limit) {
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

		if (value.compareTo(this.limit) > -1) {
			throw new AfterOfLimitException();
		}
	}

}
