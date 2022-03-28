package com.restexception.restexception.controller.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ErrorMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
    private String description;
}
