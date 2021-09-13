package com.nagarro.tables.validation;

import java.sql.Date;

import com.nagarro.tables.exception.CustomException;

public class DateValidation {
	public void  fromToValidate(Date validFrom,Date validTo) throws Exception {
		if(validTo.compareTo(validFrom)<0||(!(validTo.compareTo(validFrom)==0))) {
			throw new CustomException("Invalid Date");
		}
		
	}

}
