package com.company.classes.contracts;

import com.company.classes.account.customer.Customer;

public abstract class Contract {
    private String phone;
    private Customer customer;

    public Contract(String phone, Customer customer) {
        this.phone = phone;
        this.customer = customer;
    }

    public String getPhone() {
        return phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public abstract void saveToDatabase();
}
