package com.company.classes.account.customer;

import com.company.classes.account.Account;
import com.company.classes.account.address.Address;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.EntityClass;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.jdbc.DatabaseConnector;

import java.util.List;

public class Company extends Customer implements EntityClass {
    public static Integer unsavedObjectNumber = 0;
    private Integer id;
    private String name;
    private String nip;
    private String regon;
    private List<Account> representatives;

    public Company(String email, BillingCycle billingCycle, String name, String nip, String regon) {
        super(email, billingCycle);
        this.id = DatabaseConnector.getLowestPossibleIdValue("companies") + unsavedObjectNumber;
        this.name = name;
        this.nip = nip;
        this.regon = regon;
        unsavedObjectNumber++;
    }

    public Company(String email, BillingCycle billingCycle, CustomerAddress[] customerAddresses, String name, String nip,
                   String regon) {
        super(email, billingCycle, customerAddresses);
        this.id = DatabaseConnector.getLowestPossibleIdValue("companies") + unsavedObjectNumber;
        this.name = name;
        this.nip = nip;
        this.regon = regon;
        unsavedObjectNumber++;
    }

    public String getNip() {
        return nip;
    }

    public String getRegon() {
        return regon;
    }

    public List<Account> getRepresentatives() {
        return representatives;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void saveToDatabase() {
        String SQL = String.format("INSERT INTO companies(id, email, billing_cycle, name, nip, regon) VALUES (%s,\"%s\"," +
                "%s, \"%s\", \"%s\", \"%s\");", id, getEmail(), getBillingCycle().toInt(), name, nip, regon);
        DatabaseConnector.execute(SQL);
        unsavedObjectNumber--;
    }
}