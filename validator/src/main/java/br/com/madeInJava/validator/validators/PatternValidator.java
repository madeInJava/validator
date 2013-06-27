package br.com.madeInJava.validator.validators;

import java.util.regex.Pattern;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.pattern.FormatException;
import br.com.madeInJava.validator.exceptions.pattern.PatternNotFound;

public class PatternValidator extends AbstractValidator<String> {

	private Pattern pattern;

	public PatternValidator() {
		super();
	}

	public PatternValidator(Pattern pattern) {
		super();
		this.pattern = pattern;
	}

	public Pattern getPattern() {
		return pattern;
	}

	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	@Override
	public void validate(String value) {
		if (this.pattern == null) {
			throw new PatternNotFound();
		}

		if (!this.pattern.matcher(value).matches()) {
			throw new FormatException();
		}
	}

}
