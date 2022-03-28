package com.restexception.restexception.service.exception;

public class UniqueResultException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public UniqueResultException(String message)
    {
        super(message);
    }
}
