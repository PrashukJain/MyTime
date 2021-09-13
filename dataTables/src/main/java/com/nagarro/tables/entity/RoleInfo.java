package com.nagarro.tables.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoleInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String role;
private String scope;
private String functionRole;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getScope() {
	return scope;
}
public void setScope(String scope) {
	this.scope = scope;
}
public String getFunctionRole() {
	return functionRole;
}
public void setFunctionRole(String functionRole) {
	this.functionRole = functionRole;
}
}
