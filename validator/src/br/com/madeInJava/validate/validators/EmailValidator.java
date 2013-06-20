package br.com.madeInJava.validate.validators;

import java.util.regex.Pattern;

import br.com.madeInJava.validate.AbstractValidator;
import br.com.madeInJava.validate.exceptions.email.EmailFormatException;

public class EmailValidator extends AbstractValidator<String>{

	private static final Pattern patten = Pattern.compile("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{1,3})+$");
	
	@Override
	protected void validate(String value) {
		if (!patten.matcher(value).matches()) {
			throw new EmailFormatException();
		}
	}

}
