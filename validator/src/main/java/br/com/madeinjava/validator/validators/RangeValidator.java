package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.interval.IntervalNotFoundException;
import br.com.madeinjava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeinjava.validator.exceptions.range.OutsideOfRangeException;
import br.com.madeinjava.validator.model.Interval;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 *            Tipagem dinâmica
 */
public class RangeValidator<T extends Comparable<T>> extends AbstractValidator<T> {

	private Interval<T> interval;
	private IntervalValidator<T> intervalValidator;

	public RangeValidator() {
		super();
		this.intervalValidator = new IntervalValidator<T>();
	}

	public RangeValidator(Interval<T> interval) {
		this();
		this.interval = interval;
	}

	public Interval<T> getInterval() {
		return interval;
	}

	public void setInterval(Interval<T> interval) {
		this.interval = interval;
	}

	/**
	 * Método responsável por validar se o parâmetro em questão está em um
	 * determinado intervalo;
	 * <p>
	 * Este método utiliza o validador {@link IntervalValidator};
	 * </p>
	 * 
	 * @param value
	 *            Tipagem dinâmica. Valor a ser validado;
	 * 
	 * @exception IntervalNotFoundException
	 *                Exceção lançada quando o intervalo não é definido
	 *                previamente a invocação deste método. Para definir o
	 *                intervalo utilize os métodos de acesso (getInterval e
	 *                setInterval) ou o construtor parametrizado;
	 * @exception InvalidIntervalException
	 *                Exceção lançada quando o interválo não é válido;
	 * @exception OutsideOfRangeException
	 *                Exceção lançada quando o parâmetro não está dentro o
	 *                intervalo definido;
	 */
	@Override
	protected void validate(T value) {
		if (this.interval == null) {
			throw new IntervalNotFoundException();
		}

		this.intervalValidator.doValidation(this.interval);

		T initialValue = this.interval.getInitialValue();
		T finalValue = this.interval.getFinalValue();
		if (initialValue.compareTo(value) > 0 || finalValue.compareTo(value) < 0) {
			throw new OutsideOfRangeException();
		}
	}

}
