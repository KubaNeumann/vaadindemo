package com.example.vaadindemo.util;

import com.vaadin.data.Validator;
import com.vaadin.data.validator.IntegerValidator;

public class IntRangeValidator extends IntegerValidator implements Validator {

	private static final long serialVersionUID = 1L;

	private int min = 0;
	private int max = 0;
	private String errorMessage;

	public IntRangeValidator(int min, int max, String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.min = min;
		this.max = max;
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		super.validate(value);
		if (!isValid(value))
			throw new InvalidValueException(errorMessage);
	}

	@Override
	public boolean isValid(Object value) {
		if (!super.isValid(value))
			return false;

		Integer v = new Integer((String) value);
		if (v.intValue() < min || v.intValue() > max) {
			return false;
		}
		return true;
	}

}
