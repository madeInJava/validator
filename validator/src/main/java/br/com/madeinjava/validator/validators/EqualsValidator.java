package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeinjava.validator.exceptions.general.NotEqualsException;

/**
 * EqualsValidator.
 *
 * @param <T> Tipagem dinâmica
 * @author Renan JP
 * @version 1.0.0
 */
public class EqualsValidator<T> extends AbstractValidator<T> {

	/** model. */
	private T model;

	/**
	 * Instancia um novo equals validator.
	 */
	public EqualsValidator() {
		super();
	}

	/**
	 * Instancia um novo equals validator.
	 *
	 * @param model model
	 */
	public EqualsValidator(T model) {
		this();
		this.model = model;
	}

	/**
	 * Obtém model.
	 *
	 * @return model
	 */
	public T getModel() {
		return this.model;
	}

	/**
	 * Define model.
	 *
	 * @param model novo model
	 */
	public void setModel(T model) {
		this.model = model;
	}

	/**
	 * Método responsável por validar a igualdade entre o modelo previamente
	 * definido e o parametro em questão;.
	 *
	 * @param value Tipagem dinâmica. Valor a ser validado;
	 */
	@Override
	protected void validate(T value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (this.model == null) {
			throw new ModelNotFoundException();
		} else if (!this.model.equals(value)) {
			throw new NotEqualsException();
		}
	}

}
