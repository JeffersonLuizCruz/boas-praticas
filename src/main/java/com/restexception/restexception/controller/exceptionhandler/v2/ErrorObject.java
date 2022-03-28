package com.restexception.restexception.controller.exceptionhandler.v2;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ErrorObject implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private final String message;
    private final String field;
    private final Object parameter;
}
