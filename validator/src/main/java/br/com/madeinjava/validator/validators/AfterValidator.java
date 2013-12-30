package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.limit.BeforeOfLimitException;
import br.com.madeinjava.validator.exceptions.limit.LimitNotFoundException;

/**
 * AfterValidator.
 *
 * @param <T> Tipagem dinâmica
 * @author Renan JP
 * @version 1.0.0
 */
public class AfterValidator<T extends Comparable<T>> extends AbstractValidator<T> {

	/** limit. */
	private T limit;

	/**
	 * Instancia um novo after validator.
	 */
	public AfterValidator() {
		super();
	}

	/**
	 * Instancia um novo after validator.
	 *
	 * @param limit limit
	 */
	public AfterValidator(T limit) {
		this();
		this.limit = limit;
	}

	/**
	 * Obtém limit.
	 *
	 * @return limit
	 */
	public T getLimit() {
		return this.limit;
	}

	/**
	 * Define limit.
	 *
	 * @param limit novo limit
	 */
	public void setLimit(T limit) {
		this.limit = limit;
	}

	/**
	 * Método responsável por validar se o parâmetro em questão é maior que um
	 * determinado limite;.
	 *
	 * @param value Tipagem dinâmica. Valor a ser validado;
	 */
	@Override
	protected void validate(T value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (this.limit == null) {
			throw new LimitNotFoundException();
		} else if (value.compareTo(this.limit) < 1) {
			throw new BeforeOfLimitException();
		}
	}

}
