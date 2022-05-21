package com.company.classes.account.customer;

import com.company.classes.account.address.Address;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.contracts.Contract;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.addressModel.AddressTypeGroup;

import java.util.ArrayList;
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

    public Customer(String email, BillingCycle billingCycle, AddressTypeGroup addressType, Address address) {
        this.email = email;
        this.billingCycle = billingCycle;
        this.addresses = new ArrayList<>();
        this.addresses.add(new CustomerAddress(addressType, address));
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
}
