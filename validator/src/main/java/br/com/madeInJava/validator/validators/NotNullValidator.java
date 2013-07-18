package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.NullValueException;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 *            Tipagem dinâmica
 */
public class NotNullValidator<T> extends AbstractValidator<T> {

	/**
	 * Método responsável por validar se um determinado parâmetro é nulo;
	 * 
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 * 
	 * @exception NullValueException
	 *                Exceção lançada quando o parâmetro está nulo;
	 */
	@Override
	public void validate(T value) {
		if (value == null) {
			throw new NullValueException();
		}
	}

}
