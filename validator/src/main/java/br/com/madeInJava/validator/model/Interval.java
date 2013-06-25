package br.com.madeInJava.validator.model;

public class Interval<T extends Comparable<T>> {

	private T initialValue;
	private T finalValue;

	public Interval() {
		super();
	}

	public Interval(T initialValue, T finalValue) {
		super();
		this.initialValue = initialValue;
		this.finalValue = finalValue;
	}

	public T getInitialValue() {
		return initialValue;
	}

	public void setInitialValue(T initialValue) {
		this.initialValue = initialValue;
	}

	public T getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(T finalValue) {
		this.finalValue = finalValue;
	}

}
