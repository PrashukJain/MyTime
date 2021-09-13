package com.nagarro.tables.validation;

import java.sql.Date;

import com.nagarro.tables.entity.TimezoneInfo;
import com.nagarro.tables.exception.CustomException;

public class TimezoneInfoValidation {
	public void isValid(TimezoneInfo object) {
	isNull(object);
	isDateValid(object.getValidTo(), object.getValidFrom());
	}
	private void isNull(TimezoneInfo object) {
		if(object.getUtc()==null||object.getValidFrom()==null||object.getValidTo()==null)
			throw new CustomException("Invalid Inputs");
	}
	private void  isDateValid(Date validFrom,Date validTo)  {
		if(validTo.compareTo(validFrom)<0) {
			throw new CustomException("Invalid Date");
		}
		
	}
}
