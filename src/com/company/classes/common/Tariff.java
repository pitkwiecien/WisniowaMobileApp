package com.company.classes.common;

import java.util.Date;

public class Tariff {
    Integer id;
    Double priceForOldCustomers;
    Double priceForNewCustomers;
    Date expirationDate;

    public Tariff(Integer id, Double price, Date expirationDate) {
        this.id = id;
        this.priceForOldCustomers = price;
        this.priceForNewCustomers = price;
        this.expirationDate = expirationDate
    }

}
