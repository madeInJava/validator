package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.interval.IntervalNotFoundException;
import br.com.madeinjava.validator.exceptions.range.OutsideOfRangeException;
import br.com.madeinjava.validator.model.Interval;

/**
 * RangeValidator.
 *
 * @param <T> Tipagem dinâmica
 * @author Renan JP
 * @version 1.0.0
 */
public class RangeValidator<T extends Comparable<T>> extends AbstractValidator<T> {

	/** interval. */
	private Interval<T> interval;

	/** interval validator. */
	private IntervalValidator<T> intervalValidator;

	/**
	 * Instancia um novo range validator.
	 */
	public RangeValidator() {
		super();
		this.intervalValidator = new IntervalValidator<T>();
	}

	/**
	 * Instancia um novo range validator.
	 *
	 * @param interval interval
	 */
	public RangeValidator(Interval<T> interval) {
		this();
		this.interval = interval;
	}

	/**
	 * Obtém interval.
	 *
	 * @return interval
	 */
	public Interval<T> getInterval() {
		return this.interval;
	}

	/**
	 * Define interval.
	 *
	 * @param interval novo interval
	 */
	public void setInterval(Interval<T> interval) {
		this.interval = interval;
	}

	/**
	 * Método responsável por validar se o parâmetro em questão está em um
	 * determinado intervalo;
	 * <p>
	 * Este método utiliza o validador {@link IntervalValidator};
	 * </p>.
	 *
	 * @param value Tipagem dinâmica. Valor a ser validado;
	 */
	@Override
	protected void validate(T value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (this.interval == null) {
			throw new IntervalNotFoundException();
		} else {
			this.intervalValidator.doValidation(this.interval);
			T initialValue = this.interval.getInitialValue();
			T finalValue = this.interval.getFinalValue();
			if ((initialValue.compareTo(value) > 0) || (finalValue.compareTo(value) < 0)) {
				throw new OutsideOfRangeException();
			}
		}
	}

}
