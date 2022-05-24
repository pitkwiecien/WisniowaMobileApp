package com.company.services;

import com.company.classes.account.Account;
import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Customer;

public class AccountService {
    public static void addAccount(Account accountData, boolean savesCustomer){
        Customer customerData = (accountData.getRepresentedCompany() != null ? accountData.getRepresentedCompany() :
                accountData.getIndividual());
        if(savesCustomer && customerData.getAddresses() != null) CustomerService.addCustomer(customerData);
        accountData.saveToDatabase(customerData.getId(), customerData instanceof Company);
    }

    public static void addAccount(Account accountData){
        addAccount(accountData, false);
    }
}
