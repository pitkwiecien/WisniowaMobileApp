package com.company.services;

import com.company.classes.account.Account;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Customer;
import com.company.classes.account.customer.Individual;
import com.company.classes.model.BillingCycle;
import com.company.jdbc.DatabaseConnector;

import java.util.ArrayList;

public class CustomerService {
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

    public static Customer getCustomerById(int id, boolean isCompany){
        String database = isCompany ? "companies" : "individuals";
        String SQL = "SELECT * FROM " + database + " WHERE id = " + id + " LIMIT 1;";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[] futureCompany = dbc.interpretResultSet()[0];
        if(isCompany)
            return new Company((String) futureCompany[1], BillingCycle.toBillingCycle(futureCompany[2]), AddressService.getCustomerAddressesByCustomerId(id, true),
                    (String) futureCompany[3], (String) futureCompany[4], (String) futureCompany[5]);
        else
            return new Individual((String) futureCompany[1], BillingCycle.toBillingCycle(futureCompany[2]), AddressService.getCustomerAddressesByCustomerId(id, false),
                    (String) futureCompany[3], (String) futureCompany[4], (String) futureCompany[5]);
    }

    public static void addCustomer(Customer customer){
        ArrayList<CustomerAddress> addresses = (ArrayList<CustomerAddress>) customer.getAddresses();
        if (addresses == null) return;
        customer.saveToDatabase();
        for(CustomerAddress addressObject : addresses){
            AddressService.addCustomerAddress(addressObject, customer.getId(), customer instanceof Company);
        }
    }
}
