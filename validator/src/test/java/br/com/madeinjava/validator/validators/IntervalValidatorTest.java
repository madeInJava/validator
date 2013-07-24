package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeinjava.validator.model.Interval;

public class IntervalValidatorTest {

	private AbstractValidator<Interval<Integer>> validator;

	@Before
	public void init() {
		this.validator = new IntervalValidator<Integer>();
	}

	@Test
	public void invalidInterval() {
		assertFalse(validator.isValid(new Interval<Integer>(2, 1)));
		assertFalse(validator.isValid(new Interval<Integer>(null, 1)));
		assertFalse(validator.isValid(new Interval<Integer>(1, null)));
		assertFalse(validator.isValid(new Interval<Integer>(null, null)));
	}

	@Test
	public void validInterval() {
		assertTrue(validator.isValid(new Interval<Integer>(0, 0)));
		assertTrue(validator.isValid(new Interval<Integer>(1, 2)));
	}

	@Test(expected = InvalidIntervalException.class)
	public void throwInvalidIntervalException() {
		validator.doValidation(new Interval<Integer>(null, null));
	}
	
	
	
}
