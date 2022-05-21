package com.company.classes.invoice;

import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Customer;
import com.company.classes.contracts.Contract;

import java.util.Arrays;
import java.util.List;

public class Invoice {
    private Double amount;
    private Customer customer;
    private List<Contract> contracts;
    private boolean forCompany;

    public Invoice(Double amount, Customer customer, List<Contract> contracts) {
        this.amount = amount;
        this.customer = customer;
        this.contracts = contracts;
        this.forCompany = customer instanceof Company;
    }

    public Invoice(Double amount, Customer customer, Contract... contracts) {
        this.amount = amount;
        this.customer = customer;
        this.contracts = Arrays.stream(contracts).toList();
        this.forCompany = customer instanceof Company;
    }

    public boolean isForCompany() {
        return forCompany;
    }

    public Double getAmount() {
        return amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Contract> getContracts() {
        return contracts;
    }
}
