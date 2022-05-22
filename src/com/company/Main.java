package com.company;

import com.company.classes.account.customer.Company;
import com.company.classes.model.BillingCycle;
import com.company.jdbc.DatabaseConnector;

public class Main {
    public static void main(String[] args) {
        if(args.length >= 1)
            switch(args[0]){
                case "CREATE" -> DatabaseConnector.initiateTables();
                case "DELETE" -> DatabaseConnector.dropTables();
            }
    }
}
