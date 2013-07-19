package br.com.madeInJava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.LocaleNotFoundException;
import br.com.madeInJava.validator.exceptions.monetary.MonetaryFormatException;
import br.com.madeInJava.validator.model.Locale;

public class MonetaryValidatorTest {

	private AbstractValidator<String> brMonetaryValidator;
	private AbstractValidator<String> usMonetaryValidator;

	@Before
	public void init() {
		this.brMonetaryValidator = new MonetaryValidator();
		this.usMonetaryValidator = new MonetaryValidator(Locale.EN_US);
	}

	@Test
	public void monetaryValue() {
		assertTrue(brMonetaryValidator.isValid("9.999.999,99"));
		assertTrue(usMonetaryValidator.isValid("9,999,999.99"));
	}

	@Test
	public void notMonetayValue() {
		assertFalse(brMonetaryValidator.isValid(""));
		assertFalse(brMonetaryValidator.isValid("99"));
		assertFalse(brMonetaryValidator.isValid(".99"));
		assertFalse(brMonetaryValidator.isValid(",99"));
		assertFalse(brMonetaryValidator.isValid("999999999"));
		assertFalse(brMonetaryValidator.isValid("999.999,999"));
		assertFalse(brMonetaryValidator.isValid("9,999,999,99"));
		assertFalse(brMonetaryValidator.isValid("9.999.999.99"));
		assertFalse(brMonetaryValidator.isValid("adsad"));

		assertFalse(usMonetaryValidator.isValid(""));
		assertFalse(usMonetaryValidator.isValid("99"));
		assertFalse(usMonetaryValidator.isValid(".99"));
		assertFalse(usMonetaryValidator.isValid(",99"));
		assertFalse(usMonetaryValidator.isValid("999999999"));
		assertFalse(brMonetaryValidator.isValid("999,999.999"));
		assertFalse(usMonetaryValidator.isValid("9,999,999,99"));
		assertFalse(usMonetaryValidator.isValid("9.999.999.99"));
		assertFalse(usMonetaryValidator.isValid("adsad"));
	}

	@Test(expected = LocaleNotFoundException.class)
	public void throwLocaleNotFoundException() {
		new MonetaryValidator(null).doValidation("123,12");
	}

	@Test(expected = MonetaryFormatException.class)
	public void throwMonetaryFormatException() {
		new MonetaryValidator().doValidation("9.999.999.99");
	}

}
