package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.general.ModelNotFoundException;
import br.com.madeinjava.validator.exceptions.general.NotEqualsException;

public class EqualsValidatorTest {

	private AbstractValidator<String> validator;

	@Before
	public void init() {
		this.validator = new EqualsValidator<String>("Object");
	}

	@Test
	public void equalsValue() {
		assertTrue(this.validator.isValid("Object"));
	}

	@Test
	public void notEqualsValue() {
		assertFalse(this.validator.isValid("I'am not equals :("));
	}
	
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	@Test(expected = ModelNotFoundException.class)
	public void throwModelNotFoundException() {
		new EqualsValidator<Object>().doValidation(new Object());
	}

	@Test(expected = NotEqualsException.class)
	public void throwNotEqualsException() {
		this.validator.doValidation("I'am not equals :(");
	}

}
