package br.com.madeInJava.validator.validators;

import br.com.madeInJava.validator.AbstractValidator;
import br.com.madeInJava.validator.exceptions.general.LocaleNotFoundException;
import br.com.madeInJava.validator.exceptions.monetary.MonetaryFormatException;
import br.com.madeInJava.validator.model.Locale;

/**
 * @author Renan JP
 * @version 1.0.0
 * @param <T>
 */
public class MonetaryValidator extends AbstractValidator<String> {

	private Locale locale;
	private final String usMonetaryPattern = "\\d{1,3}(,\\d{3})*(\\.\\d{2})?";
	private final String brMonetaryPattern = "\\d{1,3}(\\.\\d{3})*(,\\d{2})?";

	public MonetaryValidator() {
		super();
		this.locale = Locale.PT_BR;
	}

	public MonetaryValidator(Locale locale) {
		super();
		this.locale = locale;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	private String getRegex() {
		switch (this.locale) {
		case PT_BR:
			return brMonetaryPattern;
		case EN_US:
			return usMonetaryPattern;
		}

		return null;
	}

	private boolean contaisFloatingPoint(String value) {
		if (Locale.PT_BR.equals(this.locale)) {
			return value.contains(",");
		} else {
			return value.contains(".");
		}
	}

	/**
	 * Método responsável por validar um determinado valor monetário;
	 * 
	 * @param value
	 *            String. Valor a ser validado;
	 * 
	 * @exception LocaleNotFoundException
	 *                Exceção lançada quando o locale não é definido previamente
	 *                a invocação deste método. Para definir o locale utilize os
	 *                métodos de acesso (getLocale e setLocale) ou o construtor
	 *                parametrizado;
	 * 
	 * @exception MonetaryFormatException
	 *                Exceção lançada quando o valor não é válido;
	 */
	@Override
	protected void validate(String value) {
		if (this.locale == null) {
			throw new LocaleNotFoundException();
		}

		if (value.startsWith("[.,]") || !contaisFloatingPoint(value) || !value.matches(this.getRegex())) {
			throw new MonetaryFormatException();
		}
	}
}
