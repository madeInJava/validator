package br.com.madeinjava.validator.validators;

import java.util.regex.Pattern;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.pattern.FormatException;
import br.com.madeinjava.validator.exceptions.pattern.PatternNotFound;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 */
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

	/**
	 * Método responsável por validar se o parâmetro em questão equivale a um
	 * determinado padrão;
	 * 
	 * @param value
	 *            String. Valor a ser validado;
	 * 
	 * @exception InvalidArgumentException
	 * 				Exceção lancada quando o parâmetro é inválido.
	 * 				Exemplo: Valor nulo; 
	 * @exception PatternNotFound
	 *                Exceção lançada quando o pattern não é definido
	 *                previamente a invocação deste método. Para definir o
	 *                pattern utilize os métodos de acesso (getPattern e
	 *                setPattern) ou o construtor parametrizado;
	 * @exception FormatException
	 *                Exceção lançada quando o parâmetro não condiz com o
	 *                padrão;
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
