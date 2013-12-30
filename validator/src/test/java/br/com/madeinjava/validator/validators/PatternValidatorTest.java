package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.pattern.FormatException;
import br.com.madeinjava.validator.exceptions.pattern.PatternNotFound;
import br.com.madeinjava.validator.model.Patterns;

/**
 * PatternValidatorTest.
 *
 * @author renan.paula
 */
public class PatternValidatorTest {

	/** validator. */
	private AbstractValidator<String> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new PatternValidator(Patterns.INTEGER.getPattern());
	}

	/**
	 * Pattern value.
	 */
	@Test
	public void patternValue() {
		assertTrue(this.validator.isValid("0123456789"));
	}

	/**
	 * Not pattern value.
	 */
	@Test
	public void notPatternValue() {
		assertFalse(this.validator.isValid(""));
		assertFalse(this.validator.isValid("a"));
		assertFalse(this.validator.isValid("a11"));
		assertFalse(this.validator.isValid("1a1"));
		assertFalse(this.validator.isValid("11a"));
	}

	/**
	 * Throw throw format exception.
	 */
	@Test(expected = FormatException.class)
	public void throwThrowFormatException() {
		this.validator.doValidation("");
	}

	/**
	 * Not throw format exception.
	 */
	@Test
	public void notThrowFormatException() {
		this.validator.doValidation("0123456789");
		assertTrue(true);
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw pattern not found.
	 */
	@Test(expected = PatternNotFound.class)
	public void throwPatternNotFound() {
		new PatternValidator().doValidation("string");
	}

}
