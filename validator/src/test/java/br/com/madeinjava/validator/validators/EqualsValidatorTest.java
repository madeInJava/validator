package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeinjava.validator.exceptions.general.NotEqualsException;

/**
 * EqualsValidatorTest.
 *
 * @author renan.paula
 */
public class EqualsValidatorTest {

	/** validator. */
	private AbstractValidator<String> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new EqualsValidator<String>("Object");
	}

	/**
	 * Equals value.
	 */
	@Test
	public void equalsValue() {
		assertTrue(this.validator.isValid("Object"));
	}

	/**
	 * Not equals value.
	 */
	@Test
	public void notEqualsValue() {
		assertFalse(this.validator.isValid("I'am not equals :("));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw model not found exception.
	 */
	@Test(expected = ModelNotFoundException.class)
	public void throwModelNotFoundException() {
		new EqualsValidator<Object>().doValidation(new Object());
	}

	/**
	 * Throw not equals exception.
	 */
	@Test(expected = NotEqualsException.class)
	public void throwNotEqualsException() {
		this.validator.doValidation("I'am not equals :(");
	}

}
