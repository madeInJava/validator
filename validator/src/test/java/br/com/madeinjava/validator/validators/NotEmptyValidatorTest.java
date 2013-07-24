package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.exceptions.general.EmptyValueException;

public class NotEmptyValidatorTest {

	private NotEmptyValidator validator;

	@Before
	public void init() {
		this.validator = new NotEmptyValidator();
	}

	@Test
	public void emptyValue() {
		assertFalse(this.validator.isValid(""));
	}

	@Test
	public void notEmptyValue() {
		assertTrue(this.validator.isValid("Not Empty"));
	}

	@Test(expected = EmptyValueException.class)
	public void throwEmptyValueException() {
		this.validator.doValidation("");
	}

	@Test
	public void notThrowEmptyValueException() {
		this.validator.doValidation("Not Empty");
		assertTrue(true);
	}
}