package br.com.madeInJava.validate.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeInJava.validate.AbstractValidator;
import br.com.madeInJava.validate.exceptions.general.NullValueException;

public class NotNullValidatorTest {

	private AbstractValidator<Object> validator;

	@Before
	public void init() {
		this.validator = new NotNullValidator<Object>();
	}

	@Test
	public void nullValue() {
		Object value = null;
		assertFalse(this.validator.isValid(value));
	}

	@Test
	public void notNullValue() {
		Object value = new Object();
		assertTrue(this.validator.isValid(value));
	}

	@Test(expected = NullValueException.class)
	public void throwNullValueException() {
		Object value = null;
		this.validator.doValidation(value);
	}

	@Test
	public void notThrowNullValueException() {
		Object value = new Object();
		this.validator.doValidation(value);
		assertTrue(true);
	}
}
