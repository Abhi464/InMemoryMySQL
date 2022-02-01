package com.inmemory.sql.factory;

import com.inmemory.sql.Column;
import com.inmemory.sql.DataType;
import com.inmemory.sql.Schema;

import java.util.HashMap;
import java.util.Map;

public class SchemaFactory {
    public static Schema getSchema(Map<String, String> columnsMap) {
        Map<String, Column> columns = new HashMap<>();
        for(Map.Entry<String, String> columnEntry: columnsMap.entrySet()) {
            Column column = new Column(columnEntry.getKey(), DataType.valueOf(columnEntry.getValue()));
            columns.put(columnEntry.getKey(), column);
        }
        return new Schema(columns);
    }
}
