package br.com.madeInJava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.limit.BeforeOfLimitException;
import br.com.madeInJava.validator.exceptions.limit.LimitNotFoundException;

public class AfterValidatorTest {

	private AbstractValidator<Integer> validator;

	@Before
	public void init() {
		this.validator = new AfterValidator<Integer>(10);
	}

	@Test
	public void afterValue() {
		assertTrue(validator.isValid(11));
	}

	@Test
	public void beforeValue() {
		assertFalse(validator.isValid(9));
	}

	@Test
	public void equalsValue() {
		assertFalse(validator.isValid(10));
	}

	@Test(expected = BeforeOfLimitException.class)
	public void throwBeforeOfLimitException() {
		validator.doValidation(9);
	}

	@Test(expected = LimitNotFoundException.class)
	public void throwLimitNotFoundException() {
		new AfterValidator<Integer>().doValidation(1);
	}

}
