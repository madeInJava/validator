package br.com.madeinjava.validator.validators;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import br.com.madeinjava.validator.AbstractValidator;
import br.com.madeinjava.validator.exceptions.interval.IntervalNotFoundException;
import br.com.madeinjava.validator.exceptions.interval.InvalidIntervalException;
import br.com.madeinjava.validator.exceptions.range.OutsideOfRangeException;
import br.com.madeinjava.validator.model.Interval;

public class RangeValidatorTest {

	private AbstractValidator<Integer> integerValidator;
	private AbstractValidator<String> stringValidator;
	private AbstractValidator<Date> dateValidator;
	private SimpleDateFormat sdf;

	@Before
	public void init() throws ParseException {
		this.integerValidator = new RangeValidator<Integer>(new Interval<Integer>(1, 5));
		this.stringValidator = new RangeValidator<String>(new Interval<String>("c", "f"));
		this.sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.dateValidator = new RangeValidator<Date>(new Interval<Date>(sdf.parse("05/06/2013"), sdf.parse("10/06/2013")));
	}

	@Test
	public void beforeInterval() throws ParseException {
		assertFalse(integerValidator.isValid(0));
		assertFalse(stringValidator.isValid("b"));
		assertFalse(dateValidator.isValid(sdf.parse("04/06/2013")));
	}

	@Test
	public void afterInterval() throws ParseException {
		assertFalse(integerValidator.isValid(6));
		assertFalse(stringValidator.isValid("g"));
		assertFalse(dateValidator.isValid(sdf.parse("11/06/2013")));
	}

	@Test
	public void inInterval() throws ParseException {
		assertTrue(integerValidator.isValid(4));
		assertTrue(stringValidator.isValid("d"));
		assertTrue(dateValidator.isValid(sdf.parse("9/06/2013")));
	}

	@Test(expected = IntervalNotFoundException.class)
	public void throwIntervalNotFoundException() {
		new RangeValidator<String>().doValidation("Exception!");
	}
	
	@Test(expected = InvalidIntervalException.class)
	public void throwInvalidIntervalException() {
		new RangeValidator<Integer>(new Interval<Integer>(6, 5)).doValidation(5);
	}
	
	@Test(expected = OutsideOfRangeException.class)
	public void throwOutsideOfRangeException() {
		integerValidator.doValidation(0);
	}
}
