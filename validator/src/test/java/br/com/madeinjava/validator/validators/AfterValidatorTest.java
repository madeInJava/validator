package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.limit.BeforeOfLimitException;
import br.com.madeinjava.validator.exceptions.limit.LimitNotFoundException;

/**
 * AfterValidatorTest.
 *
 * @author renan.paula
 */
public class AfterValidatorTest {

	/** validator. */
	private AbstractValidator<Integer> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new AfterValidator<Integer>(10);
	}

	/**
	 * After value.
	 */
	@Test
	public void afterValue() {
		assertTrue(this.validator.isValid(11));
	}

	/**
	 * Before value.
	 */
	@Test
	public void beforeValue() {
		assertFalse(this.validator.isValid(9));
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
	 * Throw before of limit exception.
	 */
	@Test(expected = BeforeOfLimitException.class)
	public void throwBeforeOfLimitException() {
		this.validator.doValidation(9);
	}

	/**
	 * Throw limit not found exception.
	 */
	@Test(expected = LimitNotFoundException.class)
	public void throwLimitNotFoundException() {
		new AfterValidator<Integer>().doValidation(1);
	}

}
