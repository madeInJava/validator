package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.exceptions.general.EmptyValueException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;

/**
 * NotEmptyValidatorTest.
 *
 * @author renan.paula
 */
public class NotEmptyValidatorTest {

	/** validator. */
	private NotEmptyValidator validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new NotEmptyValidator();
	}

	/**
	 * Empty value.
	 */
	@Test
	public void emptyValue() {
		assertFalse(this.validator.isValid(""));
	}

	/**
	 * Not empty value.
	 */
	@Test
	public void notEmptyValue() {
		assertTrue(this.validator.isValid("Not Empty"));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw empty value exception.
	 */
	@Test(expected = EmptyValueException.class)
	public void throwEmptyValueException() {
		this.validator.doValidation("");
	}

	/**
	 * Not throw empty value exception.
	 */
	@Test
	public void notThrowEmptyValueException() {
		this.validator.doValidation("Not Empty");
		assertTrue(true);
	}
}