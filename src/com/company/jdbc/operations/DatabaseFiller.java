package com.company.jdbc.operations;

import com.company.classes.account.Account;
import com.company.classes.account.customer.Company;
import com.company.classes.model.BillingCycle;
import com.company.service.AccountService;
import com.company.service.CompanyService;

public class DatabaseFiller {
    public static void fillDatabases(){
        Company microsoft = new Company("microsoft@gmail.com", BillingCycle.DAY_4, "Microsoft",
                "123-456-32-18", "123456785");
        Company google = new Company("google@wp.pl", BillingCycle.DAY_11, "Google",
                "435-323-13-53", "098947632");
        Account googler1 = new Account("Googler1", "password123", google);
        Account googler2 = new Account("Googler2", "password231", google);
        Account microsofter1 = new Account("Microsofter1", "idk_bro", microsoft);
        AccountService.addAccount(googler1, google, true);
        AccountService.addAccount(googler2, google);
        AccountService.addAccount(microsofter1, microsoft, true);
        Account[] list = CompanyService.getCompanyRepresentatives(google);
        for(Account bro : list){
            System.out.println(bro.toString());
        }
    }
}
