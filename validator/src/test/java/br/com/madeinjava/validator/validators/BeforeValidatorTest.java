package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.limit.AfterOfLimitException;
import br.com.madeinjava.validator.exceptions.limit.LimitNotFoundException;

/**
 * BeforeValidatorTest.
 *
 * @author renan.paula
 */
public class BeforeValidatorTest {

	/** validator. */
	private AbstractValidator<Integer> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new BeforeValidator<Integer>(10);
	}

	/**
	 * After value.
	 */
	@Test
	public void afterValue() {
		assertFalse(this.validator.isValid(11));
	}

	/**
	 * Before value.
	 */
	@Test
	public void beforeValue() {
		assertTrue(this.validator.isValid(9));
	}

	/**
	 * Equals value.
	 */
	@Test
	public void equalsValue() {
		assertFalse(this.validator.isValid(10));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw after of limit exception.
	 */
	@Test(expected = AfterOfLimitException.class)
	public void throwAfterOfLimitException() {
		this.validator.doValidation(11);
	}

	/**
	 * Throw limit not found exception.
	 */
	@Test(expected = LimitNotFoundException.class)
	public void throwLimitNotFoundException() {
		new BeforeValidator<Integer>().doValidation(1);
	}

}
