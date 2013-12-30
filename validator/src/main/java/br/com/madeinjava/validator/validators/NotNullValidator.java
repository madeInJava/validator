package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.NullValueException;

/**
 * NotNullValidator.
 *
 * @param <T> Tipagem dinâmica
 * @author Renan JP
 * @version 1.0.0
 */
public class NotNullValidator<T> extends AbstractValidator<T> {

	/**
	 * Método responsável por validar se um determinado parâmetro é nulo;.
	 *
	 * @param value Tipagem dinâmica. Valor a ser validado;
	 */
	@Override
	public void validate(T value) {
		if (value == null) {
			throw new NullValueException();
		}
	}

}
