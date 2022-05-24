package com.company.classes.account.customer;

import com.company.classes.account.address.Address;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.contracts.Contract;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.jdbc.DatabaseConnector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Customer {
    private String email;
    private List<Contract> contracts;
    private BillingCycle billingCycle;
    private List<CustomerAddress> addresses;

    public Customer(String email, BillingCycle billingCycle) {
        this.email = email;
        this.billingCycle = billingCycle;
    }

    public Customer(String email, BillingCycle billingCycle, CustomerAddress[] customerAddresses) {
        this.email = email;
        this.billingCycle = billingCycle;
        this.addresses = new ArrayList<>();
        Collections.addAll(this.addresses, customerAddresses);
    }

    public String getEmail() {
        return email;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public BillingCycle getBillingCycle() {
        return billingCycle;
    }

    public List<CustomerAddress> getAddresses() {
        return addresses;
    }

    public abstract void saveToDatabase();

    public abstract Integer getId();
}
