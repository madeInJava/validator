package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.interval.IntervalNotFoundException;
import br.com.madeInJava.validator.exceptions.range.OutsideOfRangeException;
import br.com.madeInJava.validator.model.Interval;

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
