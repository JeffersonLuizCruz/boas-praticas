package com.restexception.restexception.controller.exceptionhandler.v2;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class ErrorMessage implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ErrorObject> errors;
}
