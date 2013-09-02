package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeinjava.validator.model.Interval;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 *            Tipagem dinâmica
 */
public class IntervalValidator<T extends Comparable<T>> extends AbstractValidator<Interval<T>> {

	/**
	 * Método responsável por validar um determinado intervalo;
	 * 
	 * @param value
	 *            Intervalo com tipagem dinâmica. Valor a ser validado;
	 * 
	 * @exception InvalidArgumentException
	 *                Exceção lancada quando o parâmetro é inválido. Exemplo:
	 *                Valor nulo;
	 * @exception InvalidIntervalException
	 *                Exceção lançada quando o interválo não é válido;
	 */
	@Override
	protected void validate(Interval<T> value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else {
			T initialValue = value.getInitialValue();
			T finalValue = value.getFinalValue();
			if (initialValue == null || finalValue == null || initialValue.compareTo(finalValue) > 0) {
				throw new InvalidIntervalException();
			}
		}
	}

}
