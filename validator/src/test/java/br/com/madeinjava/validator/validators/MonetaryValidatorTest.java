package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.general.LocaleNotFoundException;
import br.com.madeinjava.validator.exceptions.monetary.MonetaryFormatException;
import br.com.madeinjava.validator.model.Locale;

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
		assertTrue(this.brMonetaryValidator.isValid("9.999.999,99"));
		assertTrue(this.usMonetaryValidator.isValid("9,999,999.99"));
	}

	@Test
	public void notMonetayValue() {
		assertFalse(this.brMonetaryValidator.isValid(""));
		assertFalse(this.brMonetaryValidator.isValid("99"));
		assertFalse(this.brMonetaryValidator.isValid(".99"));
		assertFalse(this.brMonetaryValidator.isValid(",99"));
		assertFalse(this.brMonetaryValidator.isValid("999999999"));
		assertFalse(this.brMonetaryValidator.isValid("999.999,999"));
		assertFalse(this.brMonetaryValidator.isValid("9,999,999,99"));
		assertFalse(this.brMonetaryValidator.isValid("9.999.999.99"));
		assertFalse(this.brMonetaryValidator.isValid("adsad"));

		assertFalse(this.usMonetaryValidator.isValid(""));
		assertFalse(this.usMonetaryValidator.isValid("99"));
		assertFalse(this.usMonetaryValidator.isValid(".99"));
		assertFalse(this.usMonetaryValidator.isValid(",99"));
		assertFalse(this.usMonetaryValidator.isValid("999999999"));
		assertFalse(this.brMonetaryValidator.isValid("999,999.999"));
		assertFalse(this.usMonetaryValidator.isValid("9,999,999,99"));
		assertFalse(this.usMonetaryValidator.isValid("9.999.999.99"));
		assertFalse(this.usMonetaryValidator.isValid("adsad"));
	}
	
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.usMonetaryValidator.doValidation(null);
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
