package com.restexception.restexception.service.exception;

public class IntegrityViolationException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public IntegrityViolationException(String message)
    {
        super(message);
    }
}
