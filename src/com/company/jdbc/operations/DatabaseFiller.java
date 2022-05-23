package com.company.jdbc.operations;

import com.company.classes.account.Account;
import com.company.classes.account.customer.Company;
import com.company.classes.model.BillingCycle;

public class DatabaseFiller {
    public static void fillDatabases(){
        Company company1 = new Company("microsoft@gmail.com", BillingCycle.DAY_4, "Microsoft",
                "123-456-32-18", "123456785");
        company1.saveToDatabase();
        Company company2 = new Company("google@wp.pl", BillingCycle.DAY_11, "Google",
                "435-323-13-53", "098947632");
        company2.saveToDatabase();
        //Account a = new Account();
    }
}
