package com.nagarro.tables.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExceptionResponse > handleCustomException(CustomException ex,
            WebRequest request) {
    	
    	ExceptionResponse response=new ExceptionResponse();
//    Map<String, Object> response = new HashMap<>();
//    // used class
//
//    response.put("success", "false");
//    response.put("message", ex.getMessage());
    	response.setErrorMessage(ex.getMessage());
    	response.setStatus(HttpStatus.BAD_REQUEST);
//    	response.setStackTrace(ex.getStackTrace());

    return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
}

}
