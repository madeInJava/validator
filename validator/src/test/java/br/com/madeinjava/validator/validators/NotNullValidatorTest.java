package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.NullValueException;

/**
 * NotNullValidatorTest.
 *
 * @author renan.paula
 */
public class NotNullValidatorTest {

	/** validator. */
	private AbstractValidator<Object> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new NotNullValidator<Object>();
	}

	/**
	 * Null value.
	 */
	@Test
	public void nullValue() {
		Object value = null;
		assertFalse(this.validator.isValid(value));
	}

	/**
	 * Not null value.
	 */
	@Test
	public void notNullValue() {
		Object value = new Object();
		assertTrue(this.validator.isValid(value));
	}

	/**
	 * Throw null value exception.
	 */
	@Test(expected = NullValueException.class)
	public void throwNullValueException() {
		Object value = null;
		this.validator.doValidation(value);
	}

	/**
	 * Not throw null value exception.
	 */
	@Test
	public void notThrowNullValueException() {
		Object value = new Object();
		this.validator.doValidation(value);
		assertTrue(true);
	}
}
