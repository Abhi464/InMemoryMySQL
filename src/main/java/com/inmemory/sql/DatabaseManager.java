package com.inmemory.sql;

import com.inmemory.sql.exceptions.TableAlreadyExistsException;
import com.inmemory.sql.exceptions.TableNotFoundException;
import com.inmemory.sql.factory.SchemaFactory;
import com.inmemory.sql.constants.Constants;

import java.util.HashMap;
import java.util.Map;

public class DatabaseManager {
    private Map<String, Table> tables;

    public DatabaseManager() {
        this.tables = new HashMap<>();
    }

    public void createTable(String tableName, Map<String, String> columnMap) {
        if(tables.containsKey(tableName)) {
            throw new TableAlreadyExistsException(String.format(Constants.TABLE_NOT_FOUND_MESSAGE, tableName));
        }
        Schema schema = SchemaFactory.getSchema(columnMap);
        Table table = new Table(schema);
        tables.put(tableName, table);
        System.out.println("Table has been created");
    }

    public void deleteTable(String tableName) {
        if(!tables.containsKey(tableName)) {
            throw new TableNotFoundException(String.format(Constants.TABLE_NOT_FOUND_MESSAGE, tableName));
        }
        tables.remove(tableName);
    }

    public void insertInTable(String tableName, Map<String, String> valueMap) {
        if(!tables.containsKey(tableName)) {
            throw new TableNotFoundException(String.format(Constants.TABLE_NOT_FOUND_MESSAGE, tableName));
        }
        Table table = tables.get(tableName);
        table.insertRow(valueMap);
    }

    public void updateInTable(String tableName, String updateColumnName, String updatedValue, String filterColumnName, String filterValue) {
        if(!tables.containsKey(tableName)) {
            throw new TableNotFoundException(String.format(Constants.TABLE_NOT_FOUND_MESSAGE, tableName));
        }
        Table table = tables.get(tableName);
        table.updateRow(updateColumnName, updatedValue, filterColumnName, filterValue);
    }

    public void deleteRowsInTable(String tableName, String filterColumnName, String filterValue) {
        if(!tables.containsKey(tableName)) {
            throw new TableNotFoundException(String.format(Constants.TABLE_NOT_FOUND_MESSAGE, tableName));
        }
        Table table = tables.get(tableName);
        table.deleteRows(filterColumnName, filterValue);
    }

    public void printAllRows(String tableName) {
        if(!tables.containsKey(tableName)) {
            throw new TableNotFoundException(String.format(Constants.TABLE_NOT_FOUND_MESSAGE, tableName));
        }
        tables.get(tableName).printAll();

    }

}
