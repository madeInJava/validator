package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.email.EmailFormatException;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.model.Patterns;

/**
 * EmailValidator.
 *
 * @author Renan JP
 * @version 1.0.0
 */
public class EmailValidator extends AbstractValidator<String> {

	/** pattern validator. */
	private PatternValidator patternValidator;

	/**
	 * Instancia um novo email validator.
	 */
	public EmailValidator() {
		this.patternValidator = new PatternValidator(Patterns.EMAIL.getPattern());
	}

	/**
	 * Método responsável por validar se o parâmetro em questão é um E-Mail;
	 * <p>
	 * Este método utiliza o validador {@link PatternValidator};
	 * </p>.
	 *
	 * @param value String. Valor a ser validado;
	 */
	@Override
	protected void validate(String value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (!this.patternValidator.isValid(value)) {
			throw new EmailFormatException();
		}
	}

}
