package com.nagarro.tables.exception;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	private String errorMessage;
//	private StackTraceElement[] stackTrace;
	private HttpStatus status;
	public String getErrorMessage() {
	return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
	}
//	public StackTraceElement[] getStackTrace() {
//		return stackTrace;
//	}
//	public void setStackTrace(StackTraceElement[] stackTrace) {
//		this.stackTrace = stackTrace;
//	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
