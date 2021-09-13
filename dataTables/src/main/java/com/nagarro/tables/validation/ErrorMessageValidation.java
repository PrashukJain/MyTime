package com.nagarro.tables.validation;

import com.nagarro.tables.entity.ErrorMessage;
import com.nagarro.tables.exception.CustomException;

public class ErrorMessageValidation {
	public void isValid(ErrorMessage object) {
		isNull(object);
	}
	private void isNull(ErrorMessage object) {
		if(object==null||object.getErrorCode()==null||object.getErrorMessage()==null||object.getLanguage()==null||object.getSeverity()==null)
			throw new CustomException("Invalid Inputs");
	}

}
