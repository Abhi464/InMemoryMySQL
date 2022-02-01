package com.inmemory.sql;

import java.util.Map;

public class Schema {
    private Map<String, Column> columns;

    public Schema(Map<String, Column> columns) {
        this.columns = columns;
    }

    public Map<String, Column> getColumns() {
        return columns;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String columnName: columns.keySet()) {
            stringBuilder.append(columnName);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

}
