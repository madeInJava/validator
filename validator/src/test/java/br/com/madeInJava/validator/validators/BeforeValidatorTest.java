package br.com.madeInJava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.limit.AfterOfLimitException;

public class BeforeValidatorTest {

	private AbstractValidator<Integer> validator;

	@Before
	public void init() {
		this.validator = new BeforeValidator<Integer>(10);
	}

	@Test
	public void afterValue() {
		assertFalse(this.validator.isValid(11));
	}

	@Test
	public void beforeValue() {
		assertTrue(this.validator.isValid(9));
	}

	@Test
	public void equalsValue() {
		assertFalse(this.validator.isValid(10));
	}

	@Test(expected = AfterOfLimitException.class)
	public void throwAfterOfLimitException() {
		validator.doValidation(11);
	}

}
