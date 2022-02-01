package com.inmemory.sql.exceptions;

public class TableAlreadyExistsException extends RuntimeException{
    public TableAlreadyExistsException(String message) {
        super(message);
    }
}
