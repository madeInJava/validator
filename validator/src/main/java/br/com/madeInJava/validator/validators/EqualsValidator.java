package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeInJava.validator.exceptions.general.NotEqualsException;

public class EqualsValidator<T> extends AbstractValidator<T> {

	private T model;

	public EqualsValidator() {
		super();
	}

	public EqualsValidator(T model) {
		this();
		this.model = model;
	}

	public T getModel() {
		return model;
	}

	public void setModel(T model) {
		this.model = model;
	}

	@Override
	protected void validate(T value) {
		if (model == null) {
			throw new ModelNotFoundException();
		}

		if (!model.equals(value)) {
			throw new NotEqualsException();
		}
	}

}
