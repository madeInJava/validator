package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.cpf.CPFCharSetException;
import br.com.madeinjava.validator.exceptions.cpf.InvalidCPFException;
import br.com.madeinjava.validator.exceptions.cpf.LenghtException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.pattern.FormatException;

/**
 * CPFValidatorTest.
 *
 * @author renan.paula
 */
public class CPFValidatorTest {

	/** validator. */
	private AbstractValidator<String> validator;

	/**
	 * Inits the.
	 */
	@Before
	public void init() {
		this.validator = new CPFValidator();
	}

	/**
	 * Equals charset.
	 */
	@Test
	public void equalsCharset() {
		assertFalse(this.validator.isValid("00000000000"));
		assertFalse(this.validator.isValid("11111111111"));
		assertFalse(this.validator.isValid("22222222222"));
		assertFalse(this.validator.isValid("33333333333"));
		assertFalse(this.validator.isValid("44444444444"));
		assertFalse(this.validator.isValid("55555555555"));
		assertFalse(this.validator.isValid("66666666666"));
		assertFalse(this.validator.isValid("77777777777"));
		assertFalse(this.validator.isValid("88888888888"));
		assertFalse(this.validator.isValid("99999999999"));

		assertFalse(this.validator.isValid("000.000.000-00"));
		assertFalse(this.validator.isValid("111.111.111-11"));
		assertFalse(this.validator.isValid("222.222.222-22"));
		assertFalse(this.validator.isValid("333.333.333-33"));
		assertFalse(this.validator.isValid("444.444.444-44"));
		assertFalse(this.validator.isValid("555.555.555-55"));
		assertFalse(this.validator.isValid("666.666.666-66"));
		assertFalse(this.validator.isValid("777.777.777-77"));
		assertFalse(this.validator.isValid("888.888.888-88"));
		assertFalse(this.validator.isValid("999.999.999-99"));
	}

	/**
	 * Not valid cpf value.
	 */
	@Test
	public void notValidCPFValue() {
		assertFalse(this.validator.isValid("35135489515"));
		assertFalse(this.validator.isValid("54568459515"));
		assertFalse(this.validator.isValid("351.354.895-15"));
		assertFalse(this.validator.isValid("545.684.595-15"));
		assertFalse(this.validator.isValid("5C5.6P4.5F5-15"));
	}

	/**
	 * Valid cpf value.
	 */
	@Test
	public void validCPFValue() {
		assertTrue(this.validator.isValid("43939271179"));
		assertTrue(this.validator.isValid("03184686116"));
		assertTrue(this.validator.isValid("439.392.711-79"));
		assertTrue(this.validator.isValid("031.846.861-16"));
	}

	/**
	 * Invalid lenght.
	 */
	@Test
	public void invalidLenght() {
		assertFalse(this.validator.isValid("439392711"));
		assertFalse(this.validator.isValid("03184686"));
		assertFalse(this.validator.isValid("439.392.11-79"));
		assertFalse(this.validator.isValid("031.846.1-16"));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.validator.doValidation(null);
	}

	/**
	 * Throw lenght exception.
	 */
	@Test(expected = LenghtException.class)
	public void throwLenghtException() {
		this.validator.doValidation("123");
	}

	/**
	 * Throw cpf char set exception.
	 */
	@Test(expected = CPFCharSetException.class)
	public void throwCPFCharSetException() {
		this.validator.doValidation("00000000000");
	}

	/**
	 * Throw invalid cpf exception.
	 */
	@Test(expected = InvalidCPFException.class)
	public void throwInvalidCPFException() {
		this.validator.doValidation("351.354.895-15");
	}

	/**
	 * Throw number format exception.
	 */
	@Test(expected = FormatException.class)
	public void throwNumberFormatException() {
		this.validator.doValidation("3C1.3P4.8F5-15");
	}
}
