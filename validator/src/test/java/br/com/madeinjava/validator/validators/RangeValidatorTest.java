package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.general.InvalidArgumentException;
import br.com.madeinjava.validator.exceptions.interval.IntervalNotFoundException;
import br.com.madeinjava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeinjava.validator.exceptions.range.OutsideOfRangeException;
import br.com.madeinjava.validator.model.Interval;

/**
 * RangeValidatorTest.
 *
 * @author renan.paula
 */
public class RangeValidatorTest {

	/** integer validator. */
	private AbstractValidator<Integer> integerValidator;

	/** string validator. */
	private AbstractValidator<String> stringValidator;

	/** date validator. */
	private AbstractValidator<Date> dateValidator;

	/** sdf. */
	private SimpleDateFormat sdf;

	/**
	 * Inits the.
	 *
	 * @throws ParseException parse exception
	 */
	@Before
	public void init() throws ParseException {
		this.integerValidator = new RangeValidator<Integer>(new Interval<Integer>(1, 5));
		this.stringValidator = new RangeValidator<String>(new Interval<String>("c", "f"));
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dateValidator = new RangeValidator<Date>(new Interval<Date>(this.sdf.parse("05/06/2013"), this.sdf.parse("10/06/2013")));
	}

	/**
	 * Before interval.
	 *
	 * @throws ParseException parse exception
	 */
	@Test
	public void beforeInterval() throws ParseException {
		assertFalse(this.integerValidator.isValid(0));
		assertFalse(this.stringValidator.isValid("b"));
		assertFalse(this.dateValidator.isValid(this.sdf.parse("04/06/2013")));
	}

	/**
	 * After interval.
	 *
	 * @throws ParseException parse exception
	 */
	@Test
	public void afterInterval() throws ParseException {
		assertFalse(this.integerValidator.isValid(6));
		assertFalse(this.stringValidator.isValid("g"));
		assertFalse(this.dateValidator.isValid(this.sdf.parse("11/06/2013")));
	}

	/**
	 * In interval.
	 *
	 * @throws ParseException parse exception
	 */
	@Test
	public void inInterval() throws ParseException {
		assertTrue(this.integerValidator.isValid(4));
		assertTrue(this.stringValidator.isValid("d"));
		assertTrue(this.dateValidator.isValid(this.sdf.parse("9/06/2013")));
	}

	/**
	 * Throw invalid argument exception.
	 */
	@Test(expected = InvalidArgumentException.class)
	public void throwInvalidArgumentException() {
		this.dateValidator.doValidation(null);
	}

	/**
	 * Throw interval not found exception.
	 */
	@Test(expected = IntervalNotFoundException.class)
	public void throwIntervalNotFoundException() {
		new RangeValidator<String>().doValidation("Exception!");
	}

	/**
	 * Throw invalid interval exception.
	 */
	@Test(expected = InvalidIntervalException.class)
	public void throwInvalidIntervalException() {
		new RangeValidator<Integer>(new Interval<Integer>(6, 5)).doValidation(5);
	}

	/**
	 * Throw outside of range exception.
	 */
	@Test(expected = OutsideOfRangeException.class)
	public void throwOutsideOfRangeException() {
		this.integerValidator.doValidation(0);
	}
}
