package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.cpf.CPFCharSetException;
import br.com.madeinjava.validator.exceptions.cpf.InvalidCPFException;
import br.com.madeinjava.validator.exceptions.cpf.LenghtException;
import br.com.madeinjava.validator.exceptions.pattern.FormatException;

public class CPFValidatorTest {

	private AbstractValidator<String> validator;

	@Before
	public void init() {
		this.validator = new CPFValidator();
	}

	@Test
	public void equalsCharset() {
		assertFalse(validator.isValid("00000000000"));
		assertFalse(validator.isValid("11111111111"));
		assertFalse(validator.isValid("22222222222"));
		assertFalse(validator.isValid("33333333333"));
		assertFalse(validator.isValid("44444444444"));
		assertFalse(validator.isValid("55555555555"));
		assertFalse(validator.isValid("66666666666"));
		assertFalse(validator.isValid("77777777777"));
		assertFalse(validator.isValid("88888888888"));
		assertFalse(validator.isValid("99999999999"));

		assertFalse(validator.isValid("000.000.000-00"));
		assertFalse(validator.isValid("111.111.111-11"));
		assertFalse(validator.isValid("222.222.222-22"));
		assertFalse(validator.isValid("333.333.333-33"));
		assertFalse(validator.isValid("444.444.444-44"));
		assertFalse(validator.isValid("555.555.555-55"));
		assertFalse(validator.isValid("666.666.666-66"));
		assertFalse(validator.isValid("777.777.777-77"));
		assertFalse(validator.isValid("888.888.888-88"));
		assertFalse(validator.isValid("999.999.999-99"));
	}

	@Test
	public void notValidCPFValue() {
		assertFalse(validator.isValid("35135489515"));
		assertFalse(validator.isValid("54568459515"));
		assertFalse(validator.isValid("351.354.895-15"));
		assertFalse(validator.isValid("545.684.595-15"));
		assertFalse(validator.isValid("5C5.6P4.5F5-15"));
	}

	@Test
	public void validCPFValue() {
		assertTrue(validator.isValid("43939271179"));
		assertTrue(validator.isValid("03184686116"));
		assertTrue(validator.isValid("439.392.711-79"));
		assertTrue(validator.isValid("031.846.861-16"));
	}

	@Test
	public void invalidLenght() {
		assertFalse(validator.isValid("439392711"));
		assertFalse(validator.isValid("03184686"));
		assertFalse(validator.isValid("439.392.11-79"));
		assertFalse(validator.isValid("031.846.1-16"));
	}

	@Test(expected = LenghtException.class)
	public void throwLenghtException() {
		validator.doValidation("123");
	}

	@Test(expected = CPFCharSetException.class)
	public void throwCPFCharSetException() {
		validator.doValidation("00000000000");
	}

	@Test(expected = InvalidCPFException.class)
	public void throwInvalidCPFException() {
		validator.doValidation("351.354.895-15");
	}
	
	@Test(expected = FormatException.class)
	public void throwNumberFormatException() {
		validator.doValidation("3C1.3P4.8F5-15");
	}
}
