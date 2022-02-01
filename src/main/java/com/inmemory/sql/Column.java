package com.inmemory.sql;

public class Column {
    private String name;
    private DataType dataType;

    public Column(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public DataType getDataType() {
        return dataType;
    }
}
