package com.company.service;

import com.company.classes.account.Account;
import com.company.classes.account.customer.Company;
import com.company.classes.model.BillingCycle;
import com.company.jdbc.DatabaseConnector;

import java.util.Arrays;

public class CompanyService {
    public static Account[] getCompanyRepresentatives(Company company){
        String SQL = "SELECT accounts.* FROM accounts JOIN companies c on c.id = accounts.represented_company_id " +
                "WHERE c.id = " + company.getId() + ";";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[][] resultSetReturn = dbc.interpretResultSet();
        Account[] accountsToReturn = new Account[resultSetReturn.length];
        int i = 0;
        for(Object[] futureAccount : resultSetReturn){
            accountsToReturn[i] = new Account((String) futureAccount[1], (String) futureAccount[2],
                    company);
            i++;
        }
        return accountsToReturn;
    }

    public static Company getCompanyById(int id){
        String SQL = "SELECT * FROM companies WHERE id = " + id + " LIMIT 1;";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[] futureCompany = dbc.interpretResultSet()[0];
        String billingCycleString = "DAY_" + futureCompany[2];
        return new Company((String) futureCompany[1], BillingCycle.valueOf(billingCycleString), (String) futureCompany[3],
                (String) futureCompany[4], (String) futureCompany[5]);
    }
}
