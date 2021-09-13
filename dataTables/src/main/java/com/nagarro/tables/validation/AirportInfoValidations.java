package com.nagarro.tables.validation;

import java.sql.Date;

import com.nagarro.tables.entity.AirportInfo;
import com.nagarro.tables.exception.CustomException;

public class AirportInfoValidations {
	public void isValid(AirportInfo object) {
		isNull(object);
		isCityValid(object.getCity());
		isCountryValid(object.getCountry());
		isFromToValidDate(object.getValidFrom(), object.getValidTo());
	}
	private void isNull(AirportInfo object){
		if(object.getCity()==null||object.getCountry()==null||object.getTitle()==null||object.getValidFrom()==null||object.getValidTo()==null)
			throw new CustomException("Invalid Inputs");
	}
	private void  isFromToValidDate(Date validFrom,Date validTo)  {
		if(validTo.compareTo(validFrom)<0||(!(validTo.compareTo(validFrom)==0))) {
			throw new CustomException("Invalid Date");
		}
		
	}
	 private void isCityValid(String s) {
	        if(s == null || !(s.matches("^[a-zA-Z ]*$"))) {
	        	throw new CustomException("Invalid City");
	        }
	     }
	 private void isCountryValid(String s) {
	        if(s == null || !(s.matches("^[a-zA-Z ]*$"))) {
	        	throw new CustomException("Invalid Country");
	        }
	     }
}
