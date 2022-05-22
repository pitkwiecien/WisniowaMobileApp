package com.company.classes.account.customer;

import com.company.classes.account.Account;
import com.company.classes.account.address.Address;
import com.company.classes.contracts.Contract;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.EntityClass;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.jdbc.DatabaseConnector;

import java.util.List;

public class Company extends Customer implements EntityClass {
    private String nip;
    private String regon;
    private List<Account> representatives;

    public Company(String email, BillingCycle billingCycle, String nip, String regon) {
        super(email, billingCycle);
        this.nip = nip;
        this.regon = regon;
    }

    public Company(String email, BillingCycle billingCycle, AddressTypeGroup addressType, Address address, String nip, String regon) {
        super(email, billingCycle, addressType, address);
        this.nip = nip;
        this.regon = regon;
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
}
