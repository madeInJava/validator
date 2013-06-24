package br.com.madeInJava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.number.NumberFormatException;
import br.com.madeInJava.validator.validators.NumberValidator;

public class NumberValidatorTest {

	private AbstractValidator<String> validator;

	@Before
	public void init() {
		this.validator = new NumberValidator();
	}

	@Test
	public void numberValue() {
		assertTrue(this.validator.isValid("0123456789"));
	}

	@Test
	public void notNumberValue() {
		assertFalse(this.validator.isValid(""));
		assertFalse(this.validator.isValid("a"));
		assertFalse(this.validator.isValid("a11"));
		assertFalse(this.validator.isValid("1a1"));
		assertFalse(this.validator.isValid("11a"));
	}

	@Test(expected = NumberFormatException.class)
	public void throwNumberFormatException() {
		this.validator.doValidation("");
	}

	@Test
	public void notThrowNumberFormatException() {
		this.validator.doValidation("0123456789");
		assertTrue(true);
	}

}
