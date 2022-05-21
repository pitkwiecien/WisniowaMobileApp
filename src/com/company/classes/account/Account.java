package com.company.classes.account;

import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Individual;

public class Account {
    private String username;
    private String password;
    private Company representedCompany;
    private Individual individual;

    public Account(String username, String password, Company representedCompany) {
        this.username = username;
        this.password = password;
        this.representedCompany = representedCompany;
        this.individual = null;
    }

    public Account(String username, String password, Individual individual) {
        this.username = username;
        this.password = password;
        this.representedCompany = null;
        this.individual = individual;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Company getRepresentedCompany() {
        return representedCompany;
    }
}
