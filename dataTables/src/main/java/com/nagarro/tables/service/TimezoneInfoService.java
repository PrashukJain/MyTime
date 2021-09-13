package com.nagarro.tables.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.tables.entity.TimezoneInfo;
import com.nagarro.tables.repository.TimezoneInfoRepository;

@Service
public class TimezoneInfoService {
	@Autowired
	TimezoneInfoRepository timezoneRepository;
	
public void addObject(TimezoneInfo objectData) {
	timezoneRepository.save(objectData);
}
public List<TimezoneInfo> fetchObject() {
	return timezoneRepository.findAll();
}
public void deleteObject(Long id) {
	timezoneRepository.deleteById(id);
}
}
