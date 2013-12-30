package br.com.madeinjava.validator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.madeinjava.validator.validators.NotEmptyValidator;
import br.com.madeinjava.validator.validators.NotNullValidator;

/**
 * ValidatorBuilderTest.
 *
 * @author renan.paula
 */
public class ValidatorBuilderTest {

	/**
	 * Null build.
	 */
	@Test
	public void nullBuild() {
		assertEquals(null, new ValidatorBuilder<String>().build());
	}

	/**
	 * One validator build.
	 */
	@Test
	public void oneValidatorBuild() {
		NotNullValidator<String> validator = new NotNullValidator<String>();
		AbstractValidator<String> buildValidator = new ValidatorBuilder<String>().withValidator(validator).build();
		assertEquals(validator, buildValidator);
		assertEquals(null, buildValidator.getNExtValidator());
	}

	/**
	 * Many validator build.
	 */
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
