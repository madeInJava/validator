package br.com.madeInJava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeInJava.validator.exceptions.general.NotEqualsException;

public class EqualsValidatorTest {

	private AbstractValidator<String> validator;

	@Before
	public void init() {
		this.validator = new EqualsValidator<String>("Object");
	}

	@Test
	public void equalsValue() {
		assertTrue(validator.isValid("Object"));
	}

	@Test
	public void notEqualsValue() {
		assertFalse(validator.isValid("I'am not equals :("));
	}

	@Test(expected = ModelNotFoundException.class)
	public void throwModelNotFoundException() {
		new EqualsValidator<Object>().doValidation(new Object());
	}

	@Test(expected = NotEqualsException.class)
	public void throwNotEqualsException() {
		validator.doValidation("I'am not equals :(");
	}

}