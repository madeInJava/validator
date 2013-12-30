package br.com.madeinjava.validator.exceptions.pattern;

/**
 * PatternNotFound.
 *
 * @author renan.paula
 */
public class PatternNotFound extends PatternException {

	/** A constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instancia um novo pattern not found.
	 */
	public PatternNotFound() {
		super("Pattern not found.");
	}

}
