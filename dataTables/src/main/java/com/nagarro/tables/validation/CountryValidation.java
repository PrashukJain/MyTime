package com.nagarro.tables.validation;

import com.nagarro.tables.exception.CustomException;

public class CountryValidation {
	 public void isCountryValid(String s) {
	        if(s == null || !(s.matches("^[a-zA-Z ]*$"))) {
	        	throw new CustomException("Invalid Country");
	        }
	     }
}
