package com.company.classes.contracts;

import com.company.classes.model.EntityClass;
import com.company.classes.tariff.PostPaidTariff;
import com.company.jdbc.DatabaseConnector;

public class PostPaidContract extends Contract implements EntityClass {
    private Double creditLimit;
    private PostPaidTariff postPaidTariff;

    public PostPaidContract(String phone, Double creditLimit, PostPaidTariff postPaidTariff) {
        super(phone);
        this.creditLimit = creditLimit;
        this.postPaidTariff = postPaidTariff;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public PostPaidTariff getPostPaidTariff() {
        return postPaidTariff;
    }
}