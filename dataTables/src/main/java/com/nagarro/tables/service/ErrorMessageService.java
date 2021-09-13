package com.nagarro.tables.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.tables.entity.ErrorMessage;
import com.nagarro.tables.repository.ErrorMessageRepository;

@Service
public class ErrorMessageService {
	@Autowired
	ErrorMessageRepository errorRepository;
	
public void addObject(ErrorMessage objectData) {
	errorRepository.save(objectData);
}
public List<ErrorMessage> fetchObject() {
	return errorRepository.findAll();
}
public void deleteObject(Long id) {
	errorRepository.deleteById(id);
}
}
