package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.email.EmailFormatException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;

/**
 * EmailValidatorTest.
 *
 * @author renan.paula
 */
public class EmailValidatorTest {

	/** validator. */
	private AbstractValidator<String> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new EmailValidator();
	}

	/**
	 * Email value.
	 */
	@Test
	public void emailValue() {
		assertTrue(this.validator.isValid("my@email.com"));
	}

	/**
	 * Not email value.
	 */
	@Test
	public void notEmailValue() {
		assertFalse(this.validator.isValid(""));
		assertFalse(this.validator.isValid("is not an e-mail"));
		assertFalse(this.validator.isValid("my@.com"));
		assertFalse(this.validator.isValid("@email.com"));
		assertFalse(this.validator.isValid("myEmail.com"));
		assertFalse(this.validator.isValid("my@email"));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw email format exception.
	 */
	@Test(expected = EmailFormatException.class)
	public void throwEmailFormatException() {
		this.validator.doValidation("is not an e-mail");
	}

	/**
	 * Not throw email format exception.
	 */
	@Test
	public void notThrowEmailFormatException() {
		this.validator.doValidation("my@email.com");
		assertTrue(true);
	}

}
