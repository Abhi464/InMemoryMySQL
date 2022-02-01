package com.inmemory.sql;

import java.util.Map;

public class Row {
    private Map<Column, String> data;

    public Row(Map<Column, String> data) {
        this.data = data;
    }

    public Map<Column, String> getData() {
        return data;
    }

//    public static printRow(Set<String> columns) {
//        StringBuilder stringBuilder = new StringBuilder();
//        for(Column column: columns) {
//            stringBuilder.append(data.get(column));
//            stringBuilder.append(" ");
//        }
//        return stringBuilder.toString();
//    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Column column: data.keySet()) {
            stringBuilder.append(data.get(column));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
