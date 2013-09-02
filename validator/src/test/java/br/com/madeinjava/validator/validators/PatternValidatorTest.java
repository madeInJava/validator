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

public class PatternValidatorTest {
	private AbstractValidator<String> validator;

	@Before
	public void init() {
		this.validator = new PatternValidator(Patterns.INTEGER.getPattern());
	}

	@Test
	public void patternValue() {
		assertTrue(this.validator.isValid("0123456789"));
	}

	@Test
	public void notPatternValue() {
		assertFalse(this.validator.isValid(""));
		assertFalse(this.validator.isValid("a"));
		assertFalse(this.validator.isValid("a11"));
		assertFalse(this.validator.isValid("1a1"));
		assertFalse(this.validator.isValid("11a"));
	}

	@Test(expected = FormatException.class)
	public void throwThrowFormatException() {
		this.validator.doValidation("");
	}

	@Test
	public void notThrowFormatException() {
		this.validator.doValidation("0123456789");
		assertTrue(true);
	}
	
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	@Test(expected = PatternNotFound.class)
	public void throwPatternNotFound() {
		new PatternValidator().doValidation("string");
	}

}
