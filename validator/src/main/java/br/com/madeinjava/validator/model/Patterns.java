package br.com.madeinjava.validator.model;

import java.util.regex.Pattern;

/**
 * Patterns.
 *
 * @author renan.paula
 */
public enum Patterns {

	/** INTEGER. */
	INTEGER("[0-9]+$"),

	/** EMAIL. */
	EMAIL("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{1,3})+$");

	/** pattern. */
	private Pattern pattern;

	/**
	 * Instancia um novo patterns.
	 *
	 * @param patterns patterns
	 */
	private Patterns(String patterns) {
		this.pattern = Pattern.compile(patterns);
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
	 * Matches.
	 *
	 * @param value value
	 * @return true, se bem sucedido
	 */
	public boolean matches(String value) {
		return this.pattern.matcher(value).matches();
	}
}
