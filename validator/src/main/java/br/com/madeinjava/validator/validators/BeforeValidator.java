package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.limit.AfterOfLimitException;
import br.com.madeinjava.validator.exceptions.limit.LimitNotFoundException;

/**
 * BeforeValidator.
 *
 * @param <T> Tipagem dinâmica
 * @author Renan JP
 * @version 1.0.0
 */
public class BeforeValidator<T extends Comparable<T>> extends AbstractValidator<T> {

	/** limit. */
	private T limit;

	/**
	 * Instancia um novo before validator.
	 */
	public BeforeValidator() {
		super();
	}

	/**
	 * Instancia um novo before validator.
	 *
	 * @param limit limit
	 */
	public BeforeValidator(T limit) {
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
	 * Método responsável por validar se o parâmetro em questão é menor que um
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
		} else if (value.compareTo(this.limit) > -1) {
			throw new AfterOfLimitException();
		}
	}

}
