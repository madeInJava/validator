package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.EmptyValueException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;

/**
 * NotEmptyValidator.
 *
 * @author Renan JP
 * @version 1.0.0
 */
public class NotEmptyValidator extends AbstractValidator<String> {

	/**
	 * Método responsável por validar se uma String não está vazia;.
	 *
	 * @param value String. Valor a ser validado;
	 */
	@Override
	public void validate(String value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (value.trim().isEmpty()) {
			throw new EmptyValueException();
		}
	}

}
