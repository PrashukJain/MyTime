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

import com.nagarro.tables.entity.TimezoneInfo;
import com.nagarro.tables.exception.CustomException;
import com.nagarro.tables.service.TimezoneInfoService;
import com.nagarro.tables.validation.TimezoneInfoValidation;

@RestController
@RequestMapping("/api")
public class TimezoneInfoController {
	@Autowired
	private TimezoneInfoService timezoneInfoService;
@PostMapping("/timezoneinfo")
public void addInfo(@RequestBody TimezoneInfo objectData) {
	try {
		new TimezoneInfoValidation().isValid(objectData);
	timezoneInfoService.addObject(objectData);}
	catch (CustomException e) {
		throw e;
	}
}
@GetMapping("/timezoneinfo")
public List<TimezoneInfo> fetchInfo() {
	return timezoneInfoService.fetchObject();
}
@DeleteMapping("/timezoneinfo/delete/{id}")
public void delete(@PathVariable("id") long id) {
	try {
    timezoneInfoService.deleteObject(id);}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
}
@PutMapping("/timezoneinfo/edit/{id}")
public void editTimezoneInfo(@PathVariable("id") long id,@RequestBody TimezoneInfo infoObject) {
	try {
	infoObject.setTimezoneId(id);
	timezoneInfoService.addObject(infoObject);
	}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
	
}
}
