package com.nagarro.tables.validation;

import com.nagarro.tables.entity.RoleInfo;
import com.nagarro.tables.exception.CustomException;

public class RoleInfoValidations {
public void isValid(RoleInfo object) {
	isNull(object);
}
private void isNull(RoleInfo object) {
	if(object==null||object.getRole()==null||object.getScope()==null||object.getFunctionRole()==null)
		throw new CustomException("Invalid Inputs");
}
}
