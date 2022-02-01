package com.inmemory.sql.factory;

import com.inmemory.sql.Column;
import com.inmemory.sql.Row;
import com.inmemory.sql.Schema;
import com.inmemory.sql.constants.Constants;
import com.inmemory.sql.exceptions.ColumnNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class RowFactory {
    public static Row getRow(Map<String, String> valuesMap, Schema schema) {
        Map<Column, String> data = new HashMap<>();
        for(Map.Entry<String, String> columnEntry: valuesMap.entrySet()) {
            if (!schema.getColumns().containsKey(columnEntry.getKey())) {
                throw new ColumnNotFoundException(String.format(Constants.COLUMN_NOT_FOUND_MESSAGE, columnEntry.getKey()));
            }
            data.put(schema.getColumns().get(columnEntry.getKey()), columnEntry.getValue());
        }
        return new Row(data);
    }



}
