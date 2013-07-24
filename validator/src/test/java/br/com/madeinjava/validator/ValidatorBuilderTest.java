package br.com.madeinjava.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.madeinjava.validator.validators.NotEmptyValidator;
import br.com.madeinjava.validator.validators.NotNullValidator;

public class ValidatorBuilderTest {
	
	@Test
	public void nullBuild() {
		assertEquals(null, new ValidatorBuilder<String>().build());
	}
	
	@Test
	public void oneValidatorBuild() {
		NotNullValidator<String> validator = new NotNullValidator<String>();
		AbstractValidator<String> buildValidator = new ValidatorBuilder<String>().withValidator(validator).build();
		assertEquals(validator, buildValidator);
		assertEquals(null, buildValidator.getNExtValidator());
	}
	
	@Test
	public void manyValidatorBuild() {
		NotNullValidator<String> first = new NotNullValidator<String>();
		NotEmptyValidator second = new NotEmptyValidator();
		
		AbstractValidator<String> buildValidator = new ValidatorBuilder<String>()
				.withValidator(first)
				.withValidator(second)
				.build();
		
		assertEquals(first, buildValidator);
		assertEquals(second, buildValidator.getNExtValidator());
		assertEquals(null, buildValidator.getNExtValidator().getNExtValidator());
	}
	
}
