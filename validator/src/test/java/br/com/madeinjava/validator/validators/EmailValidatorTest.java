package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.email.EmailFormatException;

public class EmailValidatorTest {

	private AbstractValidator<String> validator;

	@Before
	public void init() {
		this.validator = new EmailValidator();
	}

	@Test
	public void emailValue() {
		assertTrue(this.validator.isValid("my@email.com"));
	}

	@Test
	public void notEmailValue() {
		assertFalse(this.validator.isValid(""));
		assertFalse(this.validator.isValid("is not an e-mail"));
		assertFalse(this.validator.isValid("my@.com"));
		assertFalse(this.validator.isValid("@email.com"));
		assertFalse(this.validator.isValid("myEmail.com"));
		assertFalse(this.validator.isValid("my@email"));
	}

	@Test(expected = EmailFormatException.class)
	public void throwEmailFormatException() {
		this.validator.doValidation("is not an e-mail");
	}

	@Test
	public void notThrowEmailFormatException() {
		this.validator.doValidation("my@email.com");
		assertTrue(true);
	}

}
