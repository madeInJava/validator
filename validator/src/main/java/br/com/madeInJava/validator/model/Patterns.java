package br.com.madeInJava.validator.model;

import java.util.regex.Pattern;

public enum Patterns {
	INTEGER("[0-9]+$");

	private Pattern pattern;

	private Patterns(String patterns) {
		this.pattern = Pattern.compile(patterns);
	}

	public Pattern getPattern() {
		return this.pattern;
	}

	public boolean matches(String value) {
		return pattern.matcher(value).matches();
	}
}
