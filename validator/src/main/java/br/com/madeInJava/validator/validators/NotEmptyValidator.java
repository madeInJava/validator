package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.EmptyValueException;

/**
 * @author Renan JP
 * @version 1.0.0
 */
public class NotEmptyValidator extends AbstractValidator<String> {

	/**
	 * Método responsável por validar se uma String não está vazia;
	 * 
	 * @param value
	 *            String. Valor a ser validado;
	 * 
	 * @exception EmptyValueException
	 *                Exceção lançada quando o parâmetro está vazio;
	 */
	@Override
	public void validate(String value) {
		if (value.toString().trim().isEmpty()) {
			throw new EmptyValueException();
		}
	}

}
