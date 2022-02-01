package com.inmemory.sql;

import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        Map<String, String> schema = new HashMap<>();
        String tblName = "employee";
        schema.put("id", "STRING");
        schema.put("name", "STRING");
        databaseManager.createTable(tblName, schema);

        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("id", "1");
        valuesMap.put("name", "a");
        try {
            databaseManager.insertInTable(tblName,valuesMap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================");
        valuesMap = new HashMap<>();
        valuesMap.put("id", "2");
        valuesMap.put("name", "b");
        try {
            databaseManager.insertInTable(tblName,valuesMap);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("=====================");
        try {
            databaseManager.updateInTable(tblName, "name", "a", "id", "2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================");
        try {
            databaseManager.deleteRowsInTable(tblName, "name", "a");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================");

    }
}
