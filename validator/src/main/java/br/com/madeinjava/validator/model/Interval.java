package br.com.madeinjava.validator.model;

/**
 * Interval.
 *
 * @param <T> tipo genérico
 * @author renan.paula
 */
public class Interval<T extends Comparable<T>> {

	/** initial value. */
	private T initialValue;

	/** final value. */
	private T finalValue;

	/**
	 * Instancia um novo interval.
	 */
	public Interval() {
		super();
	}

	/**
	 * Instancia um novo interval.
	 *
	 * @param initialValue initial value
	 * @param finalValue final value
	 */
	public Interval(T initialValue, T finalValue) {
		super();
		this.initialValue = initialValue;
		this.finalValue = finalValue;
	}

	/**
	 * Obtém initial value.
	 *
	 * @return initial value
	 */
	public T getInitialValue() {
		return this.initialValue;
	}

	/**
	 * Define initial value.
	 *
	 * @param initialValue novo initial value
	 */
	public void setInitialValue(T initialValue) {
		this.initialValue = initialValue;
	}

	/**
	 * Obtém final value.
	 *
	 * @return final value
	 */
	public T getFinalValue() {
		return this.finalValue;
	}

	/**
	 * Define final value.
	 *
	 * @param finalValue novo final value
	 */
	public void setFinalValue(T finalValue) {
		this.finalValue = finalValue;
	}

}
