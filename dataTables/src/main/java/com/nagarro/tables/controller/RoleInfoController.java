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

import com.nagarro.tables.entity.RoleInfo;
import com.nagarro.tables.exception.CustomException;
import com.nagarro.tables.service.RoleInfoService;
import com.nagarro.tables.validation.RoleInfoValidations;

@RestController
@RequestMapping("/api")
public class RoleInfoController {
	@Autowired
	private RoleInfoService roleInfoService;
@PostMapping("/roleinfo")
public void addInfo(@RequestBody RoleInfo objectData) {
	try {
		new RoleInfoValidations().isValid(objectData);
	roleInfoService.addObject(objectData);}
	catch(CustomException e) {
	throw e;
	}
}
@GetMapping("/roleinfo")
public List<RoleInfo> fetchInfo() {
	return roleInfoService.fetchObject();
}
@DeleteMapping("roleinfo/delete/{id}")
public void delete(@PathVariable("id") long id) {
	try {
    roleInfoService.deleteObject(id);}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
}
@PutMapping("roleinfo/edit/{id}")
public void editRoleInfo(@PathVariable("id") long id,@RequestBody RoleInfo infoObject) {
	try {
	infoObject.setId(id);
	roleInfoService.addObject(infoObject);}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
}
}
