package br.com.madeinjava.validator.validators;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.general.LocaleNotFoundException;
import br.com.madeinjava.validator.exceptions.monetary.MonetaryFormatException;
import br.com.madeinjava.validator.model.Locale;

/**
 * MonetaryValidator.
 * 
 * @author Renan JP
 * @version 1.0.0
 */
public class MonetaryValidator extends AbstractValidator<String> {

	/** locale. */
	private Locale locale;

	/** A constante US_MONETARY_PATTERN. */
	private static final String US_MONETARY_PATTERN = "\\d{1,3}(,\\d{3})*(\\.\\d{2})?";

	/** A constante BR_MONETARY_PATTERN. */
	private static final String BR_MONETARY_PATTERN = "\\d{1,3}(\\.\\d{3})*(,\\d{2})?";

	/**
	 * Instancia um novo monetary validator.
	 */
	public MonetaryValidator() {
		super();
		this.locale = Locale.PT_BR;
	}

	/**
	 * Instancia um novo monetary validator.
	 * 
	 * @param locale
	 *            locale
	 */
	public MonetaryValidator(Locale locale) {
		super();
		this.locale = locale;
	}

	/**
	 * Obtém locale.
	 * 
	 * @return locale
	 */
	public Locale getLocale() {
		return this.locale;
	}

	/**
	 * Define locale.
	 * 
	 * @param locale
	 *            novo locale
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * Obtém regex.
	 * 
	 * @return regex
	 */
	private String getRegex() {
		switch (this.locale) {
		case PT_BR:
			return BR_MONETARY_PATTERN;
		case EN_US:
			return US_MONETARY_PATTERN;
		}

		return null;
	}

	/**
	 * Contais floating point.
	 * 
	 * @param value
	 *            value
	 * @return true, se bem sucedido
	 */
	private boolean contaisFloatingPoint(String value) {
		if (Locale.PT_BR.equals(this.locale)) {
			return value.contains(",");
		} else {
			return value.contains(".");
		}
	}

	/**
	 * Método responsável por validar um determinado valor monetário;.
	 * 
	 * @param value
	 *            String. Valor a ser validado;
	 */
	@Override
	protected void validate(String value) {
		if (value == null) {
			throw new InvalidArgumentException();
		} else if (this.locale == null) {
			throw new LocaleNotFoundException();
		} else if (value.startsWith("[.,]") || !this.contaisFloatingPoint(value) || !value.matches(this.getRegex())) {
			throw new MonetaryFormatException();
		}
	}
}
