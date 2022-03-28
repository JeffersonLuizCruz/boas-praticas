package com.restexception.restexception.controller.exceptionhandler.v2;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ApiError implements Serializable
{    
    private static final long serialVersionUID = 1L;
    
    private int code;
    private LocalDateTime date;
    private String msg;
    private String path;
}
