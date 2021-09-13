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

import com.nagarro.tables.entity.AirportInfo;
import com.nagarro.tables.exception.CustomException;
import com.nagarro.tables.service.AirportInfoService;
import com.nagarro.tables.validation.AirportInfoValidations;



@RestController
@RequestMapping("/api")
public class AirportInfoController {
	@Autowired
	private AirportInfoService airportInfoService;
@PostMapping("/airportInfo")
public void addInfo(@RequestBody AirportInfo objectData) throws Exception{
	System.out.println("add airport Info");
try {
	new AirportInfoValidations().isValid(objectData);
	airportInfoService.addObject(objectData);
}
catch(CustomException e) {
throw e;
}

}
@GetMapping("/airportInfo")
public List<AirportInfo> fetchInfo() {
	return airportInfoService.fetchObject();
}
@DeleteMapping("/delete/{id}")
public void delete(@PathVariable("id") long id) {
	try {
    airportInfoService.deleteObject(id);}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
}
@PutMapping("/edit/{id}")
public void editAirportInfo(@PathVariable("id") long id,@RequestBody AirportInfo infoObject) {
	try {
	infoObject.setAirportId(id);
	airportInfoService.addObject(infoObject);
	}
	catch(Exception e) {
		throw new CustomException("Resource not found(Invalid Id)");
	}
	
}
@GetMapping("/airportinfo/city/{city}")
public List<AirportInfo> getByCity(@PathVariable("city") String city) {
	System.out.println(city);
return airportInfoService.fetchByCity(city);
}
@GetMapping("/airportinfo/country/{country}")
public List<AirportInfo> getByCountry(@PathVariable("country") String country) {
return airportInfoService.fetchByCity(country);
}

}
