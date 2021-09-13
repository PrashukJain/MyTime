package com.nagarro.tables.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.tables.entity.AirportInfo;
import com.nagarro.tables.repository.AirportInfoRepository;

@Service
public class AirportInfoService {
	@Autowired
	AirportInfoRepository airportRepository;
	
public void addObject(AirportInfo objectData) {
	airportRepository.save(objectData);
}
public List<AirportInfo> fetchObject() {
	return airportRepository.findAll();
}
public void deleteObject(Long id) {
	airportRepository.deleteById(id);
}
public List<AirportInfo> fetchByCity(String city){
	return airportRepository.getByCity(city);
}
public List<AirportInfo> fetchByCountry(String country){
	return airportRepository.getByCity(country);
}

}
