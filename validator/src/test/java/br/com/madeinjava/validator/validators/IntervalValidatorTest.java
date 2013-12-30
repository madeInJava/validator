package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeinjava.validator.model.Interval;

/**
 * IntervalValidatorTest.
 *
 * @author renan.paula
 */
public class IntervalValidatorTest {

	/** validator. */
	private AbstractValidator<Interval<Integer>> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new IntervalValidator<Integer>();
	}

	/**
	 * Invalid interval.
	 */
	@Test
	public void invalidInterval() {
		assertFalse(this.validator.isValid(new Interval<Integer>(2, 1)));
		assertFalse(this.validator.isValid(new Interval<Integer>(null, 1)));
		assertFalse(this.validator.isValid(new Interval<Integer>(1, null)));
		assertFalse(this.validator.isValid(new Interval<Integer>(null, null)));
	}

	/**
	 * Valid interval.
	 */
	@Test
	public void validInterval() {
		assertTrue(this.validator.isValid(new Interval<Integer>(0, 0)));
		assertTrue(this.validator.isValid(new Interval<Integer>(1, 2)));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw invalid interval exception.
	 */
	@Test(expected = InvalidIntervalException.class)
	public void throwInvalidIntervalException() {
		this.validator.doValidation(new Interval<Integer>(null, null));
	}

}
