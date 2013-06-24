package br.com.madeInJava.validator;

import br.com.madeInJava.validator.validators.CPFValidator;
import br.com.madeInJava.validator.validators.EmailValidator;
import br.com.madeInJava.validator.validators.NotEmptyValidator;
import br.com.madeInJava.validator.validators.NotNullValidator;
import br.com.madeInJava.validator.validators.NumberValidator;

public abstract class Validator {
	
	private static AbstractValidator<String> numberValidator;
	private static AbstractValidator<String> notEmptyValidator;
	private static AbstractValidator<String> emailValidator;
	private static AbstractValidator<String> cpfValidator;
	
	public static AbstractValidator<String> getNumberValidator() {
		if(numberValidator == null) {
			numberValidator = new ValidatorBuilder<String>()
				.withValidator(new NotNullValidator<String>())
				.withValidator(new NotEmptyValidator())
				.withValidator(new NumberValidator())
				.build();
		}
		return numberValidator;
	}
	
	public static AbstractValidator<String> getNotEmptyValidator() {
		if(notEmptyValidator == null) {
			notEmptyValidator = new ValidatorBuilder<String>()
				.withValidator(new NotNullValidator<String>())
				.withValidator(new NotEmptyValidator())
				.build();
		}
		
		return notEmptyValidator;
	}
	
	public static AbstractValidator<String> getEmailValidator() {
		if(emailValidator == null) {
			emailValidator = new ValidatorBuilder<String>()
				.withValidator(new NotNullValidator<String>())
				.withValidator(new NotEmptyValidator())
				.withValidator(new EmailValidator())
				.build();
		}
		
		return emailValidator;
	}
	
	public static AbstractValidator<String> getCPFValidator() {
		if(cpfValidator == null) {
			cpfValidator = new ValidatorBuilder<String>()
				.withValidator(new NotNullValidator<String>())
				.withValidator(new NotEmptyValidator())
				.withValidator(new CPFValidator())
				.build();
		}
		
		return cpfValidator;
	}
}
