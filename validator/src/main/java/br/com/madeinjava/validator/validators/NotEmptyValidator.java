package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.EmptyValueException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;

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
	 * @exception InvalidArgumentException
	 * 				Exceção lancada quando o parâmetro é inválido.
	 * 				Exemplo: Valor nulo;
	 * @exception EmptyValueException
	 *                Exceção lançada quando o parâmetro está vazio;
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
