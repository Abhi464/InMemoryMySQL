package com.inmemory.sql.exceptions;

public class TableNotFoundException extends RuntimeException{

    public TableNotFoundException(String message) {
        super(message);
    }
}
