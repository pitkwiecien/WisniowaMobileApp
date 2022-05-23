package com.company.classes.account;

import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Individual;
import com.company.classes.model.EntityClass;
import com.company.jdbc.DatabaseConnector;

public class Account implements EntityClass {
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

    public void saveToDatabase(Integer customerId, Boolean isCompany) {
        Integer companyId = null;
        Integer individualId = null;
        if(isCompany) companyId = customerId;
        else individualId = customerId;
        String SQL = String.format("INSERT INTO accounts(username, password, represented_company_id, individual_id)" +
                " VALUES (\"%s\", \"%s\", %s, %s);", username, password, companyId, individualId);
        DatabaseConnector.execute(SQL);
    }

    @Override
    public String toString(){
        return "username: " + this.getUsername() + ", password: " + this.getPassword() +
                (representedCompany != null ? ", company NIP:" + representedCompany.getNip() :
                        ", pesel: " + individual.getPesel());
    }
}
