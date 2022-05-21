package com.company.classes.account.customer;

import com.company.classes.account.address.Address;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.addressModel.AddressTypeGroup;

public class Individual extends Customer {
    private String firstName;
    private String lastName;
    private String pesel;

    public Individual(String email, BillingCycle billingCycle, String firstName, String lastName, String pesel) {
        super(email, billingCycle);
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public Individual(String email, BillingCycle billingCycle, AddressTypeGroup addressType, Address address, String firstName, String lastName, String pesel) {
        super(email, billingCycle, addressType, address);
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }
}
