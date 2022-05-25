package com.company;

import com.company.classes.model.BillingCycle;
import com.company.jdbc.DatabaseConnector;
import com.company.jdbc.operations.DatabaseFiller;

public class Main {
    public static void main(String[] args) {
        if(args.length >= 1)
            switch(args[0]){
                case "CREATE" -> {
                    DatabaseConnector.initiateTables();
                    DatabaseFiller.fillDatabases();
                }
                case "DELETE" -> DatabaseConnector.dropTables();
                case "RESET" -> {
                    DatabaseConnector.dropTables();
                    DatabaseConnector.initiateTables();
                    DatabaseFiller.fillDatabases();
                }
            }
    }
}
