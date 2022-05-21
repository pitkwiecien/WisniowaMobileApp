package com.company.classes.contracts;

import com.company.classes.tariff.PostPaidTariff;

public class PostPaidContract extends Contract {
    private Double creditLimit;
    private PostPaidTariff postPaidTariff;

    public PostPaidContract(String phone, Double creditLimit, PostPaidTariff postPaidTariff) {
        super(phone);
        this.creditLimit = creditLimit;
        this.postPaidTariff = postPaidTariff;
    }
}