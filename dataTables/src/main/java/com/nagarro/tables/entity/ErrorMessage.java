package com.nagarro.tables.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ErrorMessage {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String errorCode;
private String language;
private String errorMessage;
private String severity;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getLanguage() {
	return language;
}
public void setLanguage(String language) {
	this.language = language;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
public String getSeverity() {
	return severity;
}
public void setSeverity(String severity) {
	this.severity = severity;
}
}
