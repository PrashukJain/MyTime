package com.nagarro.tables.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.tables.entity.ErrorMessage;
import com.nagarro.tables.exception.CustomException;
import com.nagarro.tables.service.ErrorMessageService;
import com.nagarro.tables.validation.ErrorMessageValidation;


@RestController
@RequestMapping("/api")
public class ErrorMessageController {
	@Autowired
	private ErrorMessageService errorMessageService;
@PostMapping("/errormessage")
public void addInfo(@RequestBody ErrorMessage objectData) {
	try {
		new ErrorMessageValidation().isValid(objectData);
	errorMessageService.addObject(objectData);}
	catch(CustomException e) {
		throw e;
	}
}
@GetMapping("/errormessage")
public List<ErrorMessage> fetchInfo() {
	return errorMessageService.fetchObject();
}
@DeleteMapping("errormessage/delete/{id}")
public void delete(@PathVariable("id") long id) {
	try {
    errorMessageService.deleteObject(id);}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
}
@PutMapping("/errormessage/edit/{id}")
public void editAirportInfo(@PathVariable("id") long id,@RequestBody ErrorMessage infoObject) {
	try {
	infoObject.setId(id);
	errorMessageService.addObject(infoObject);}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
}
}
