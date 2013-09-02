package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.limit.AfterOfLimitException;
import br.com.madeinjava.validator.exceptions.limit.LimitNotFoundException;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 *            Tipagem dinâmica
 */
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

	/**
	 * Método responsável por validar se o parâmetro em questão é menor que um
	 * determinado limite;
	 * 
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 * 
	 * @exception InvalidArgumentException
	 * 				Exceção lancada quando o parâmetro é inválido.
	 * 				Exemplo: Valor nulo; 
	 * @exception LimitNotFoundException
	 *                Exceção lançada quando o limite não é definido previamente
	 *                a invocação deste método. Para definir o limite utilize os
	 *                métodos de acesso (getLimit e setLimit) ou o construtor
	 *                parametrizado;
	 * @exception AfterOfLimitException
	 *                Exceção lançada quando o parâmetro é maior ou igual ao
	 *                limite estipulado;
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
