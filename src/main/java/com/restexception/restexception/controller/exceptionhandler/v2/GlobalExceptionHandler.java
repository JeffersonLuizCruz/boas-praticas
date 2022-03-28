package com.restexception.restexception.controller.exceptionhandler.v2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restexception.restexception.service.exception.IntegrityViolationException;
import com.restexception.restexception.service.exception.NotFoundException;
import com.restexception.restexception.service.exception.UniqueResultException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler
{
    
    private final String ARGUMENT_NOT_VALID_EXCEPTION = "Campo inválido!";
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiError> resourceNotFoundException(NotFoundException ex, WebRequest request) {
        ApiError message = new ApiError(
          HttpStatus.NOT_FOUND.value(),
          LocalDateTime.now(),
          ex.getMessage(),
          request.getDescription(false));
      
      return new ResponseEntity<ApiError>(message, HttpStatus.NOT_FOUND);
    }
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> globalExceptionHandler(Exception ex, WebRequest request) {
        ApiError message = new ApiError(
          HttpStatus.INTERNAL_SERVER_ERROR.value(),
          LocalDateTime.now(),
          ex.getMessage(),
          request.getDescription(false));
      
      return new ResponseEntity<ApiError>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(UniqueResultException.class)
    public ResponseEntity<ApiError> uniqueResultException(UniqueResultException ex, WebRequest request) {
        ApiError message = new ApiError(
          HttpStatus.NOT_ACCEPTABLE.value(),
          LocalDateTime.now(),
          ex.getMessage(),
          request.getDescription(false));
      
      return new ResponseEntity<ApiError>(message, HttpStatus.NOT_ACCEPTABLE);
    }
    
    @ExceptionHandler(IntegrityViolationException.class)
    public ResponseEntity<ApiError> integrityViolationException(IntegrityViolationException ex, WebRequest request) {
        ApiError message = new ApiError(
          HttpStatus.NOT_ACCEPTABLE.value(),
          LocalDateTime.now(),
          ex.getMessage(),
          request.getDescription(false));
      
      return new ResponseEntity<ApiError>(message, HttpStatus.NOT_ACCEPTABLE);
    }
    
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorObject> errors = getErrors(ex);
        ErrorMessage errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private ErrorMessage getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
        return new ErrorMessage(ARGUMENT_NOT_VALID_EXCEPTION, status.value(),
                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
    }

    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
}
