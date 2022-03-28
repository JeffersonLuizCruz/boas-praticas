package com.restexception.restexception.controller.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.restexception.restexception.service.exception.NotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorMessage> resourceNotFoundException(NotFoundException ex, WebRequest request) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now(),
          ex.getMessage(),
          request.getDescription(false));
      
      return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
      ErrorMessage message = new ErrorMessage(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          LocalDateTime.now(),
          ex.getMessage(),
          request.getDescription(false));
      
      return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
