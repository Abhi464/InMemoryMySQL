package com.inmemory.sql.exceptions;

public class ColumnNotFoundException extends RuntimeException{
    public ColumnNotFoundException(String message) {
        super(message);
    }
}
