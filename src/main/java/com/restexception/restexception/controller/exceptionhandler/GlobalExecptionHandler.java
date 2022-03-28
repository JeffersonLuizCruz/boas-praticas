package com.restexception.restexception.controller.exceptionhandler;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExecptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
//		List<String> errors = new ArrayList<String>();
//		
//		ex.getBindingResult().getAllErrors().forEach(error -> {
//			errors.add(error.getDefaultMessage());
//		});
		
		List<String> errors = ex.getBindingResult()
								.getAllErrors()
								.stream()
								.map(p -> p.getDefaultMessage())
								.collect(Collectors.toList());
		
		String defaultMessage = "Invalid field(s)";
		
		ApiErrorList error = new ApiErrorList(HttpStatus.BAD_REQUEST.value(), defaultMessage, Instant.now(), errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
