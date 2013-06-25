package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeInJava.validator.model.Interval;

public class IntervalValidator<T extends Comparable<T>> extends AbstractValidator<Interval<T>> {

	@Override
	protected void validate(Interval<T> value) {
		T initialValue = value.getInitialValue();
		T finalValue = value.getFinalValue();
		if (initialValue == null || finalValue == null || initialValue.compareTo(finalValue) > 0) {
			throw new InvalidIntervalException();
		}
	}

}
