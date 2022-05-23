package com.company.service;

import com.company.classes.account.Account;
import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Customer;

public class AccountService {
    public static void addAccount(Account accountData, Customer customerData, boolean savesCustomer){
        if(savesCustomer) customerData.saveToDatabase();
        accountData.saveToDatabase(customerData.getId(), customerData instanceof Company);
    }

    public static void addAccount(Account accountData, Customer customerData){
        addAccount(accountData, customerData, false);
    }

}
