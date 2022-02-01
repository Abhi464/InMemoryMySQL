package com.inmemory.sql;

import com.inmemory.sql.constants.Constants;
import com.inmemory.sql.exceptions.ColumnNotFoundException;
import com.inmemory.sql.factory.RowFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
    private Schema schema;
    private List<Row> rows;

    public Table(Schema schema) {
        this.schema = schema;
        this.rows = new ArrayList<>();
    }

    public Schema getSchema() {
        return schema;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void insertRow(Map<String, String> valueMap) {
        if(valueMap.size() != schema.getColumns().size()) {
            throw new RuntimeException("Values do not match the column");
        }
        rows.add(RowFactory.getRow(valueMap, schema));
        printAll();
    }

    public void updateRow(String updateColumnName, String updatedValue, String filterColumnName, String filterValue) {
        if (!schema.getColumns().containsKey(filterColumnName)) {
            throw new ColumnNotFoundException(String.format(Constants.COLUMN_NOT_FOUND_MESSAGE, filterColumnName));
        }
        else if(!schema.getColumns().containsKey(updateColumnName)) {
            throw new ColumnNotFoundException(String.format(Constants.COLUMN_NOT_FOUND_MESSAGE, updateColumnName));
        }

        for(Row row : rows) {
            if(row.getData().get(schema.getColumns().get(filterColumnName)).equals(filterValue)) {
                row.getData().put(schema.getColumns().get(updateColumnName), updatedValue);
            }
        }
        printAll();
    }

    public void printAll() {
        System.out.println(schema);
        rows.forEach((row) -> {
            System.out.println(row);
        });

    }

    public void deleteRows(String filterColumnName, String filterValue) {
        if (!schema.getColumns().containsKey(filterColumnName)) {
            throw new ColumnNotFoundException(String.format(Constants.COLUMN_NOT_FOUND_MESSAGE, filterColumnName));
        }
        List<Row> updatedRows = new ArrayList<>();
        for(Row row : rows) {
            if(!row.getData().get(schema.getColumns().get(filterColumnName)).equals(filterValue)) {
                updatedRows.add(row);
            }
        }
        rows = updatedRows;
        printAll();
    }

}
