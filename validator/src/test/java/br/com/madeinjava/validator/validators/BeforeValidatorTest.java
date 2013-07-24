package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.limit.AfterOfLimitException;
import br.com.madeinjava.validator.exceptions.limit.LimitNotFoundException;

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

	@Test(expected = LimitNotFoundException.class)
	public void throwLimitNotFoundException() {
		new BeforeValidator<Integer>().doValidation(1);
	}

}
