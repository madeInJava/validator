package br.com.madeinjava.validator.validators;

import java.util.regex.Pattern;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.pattern.FormatException;
import br.com.madeinjava.validator.exceptions.pattern.PatternNotFound;

/**
 * PatternValidator.
 *
 * @author Renan JP
 * @version 1.0.0
 */
public class PatternValidator extends AbstractValidator<String> {

	/** pattern. */
	private Pattern pattern;

	/**
	 * Instancia um novo pattern validator.
	 */
	public PatternValidator() {
		super();
	}

	/**
	 * Instancia um novo pattern validator.
	 *
	 * @param pattern pattern
	 */
	public PatternValidator(Pattern pattern) {
		super();
		this.pattern = pattern;
	}

	/**
	 * Obtém pattern.
	 *
	 * @return pattern
	 */
	public Pattern getPattern() {
		return this.pattern;
	}

	/**
	 * Define pattern.
	 *
	 * @param pattern novo pattern
	 */
	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}

	/**
	 * Método responsável por validar se o parâmetro em questão equivale a um
	 * determinado padrão;.
	 *
	 * @param value String. Valor a ser validado;
	 */
	@Override
	public void validate(String value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (this.pattern == null) {
			throw new PatternNotFound();
		} else if (!this.pattern.matcher(value).matches()) {
			throw new FormatException();
		}
	}

}
