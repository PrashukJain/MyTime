package com.nagarro.tables.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.tables.entity.RoleInfo;
import com.nagarro.tables.repository.RoleInfoRepository;

@Service
public class RoleInfoService {
	@Autowired
	RoleInfoRepository roleInfoRepository;
	
public void addObject(RoleInfo objectData) {
	roleInfoRepository.save(objectData);
}
public List<RoleInfo> fetchObject() {
	return roleInfoRepository.findAll();
}
public void deleteObject(Long id) {
	roleInfoRepository.deleteById(id);
}
}
