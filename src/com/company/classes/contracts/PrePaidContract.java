package com.company.classes.contracts;

import com.company.classes.tariff.PrePaidTariff;

public class PrePaidContract extends Contract {
    private PrePaidTariff prePaidTariff;

    public PrePaidContract(String phone, PrePaidTariff prePaidTariff) {
        super(phone);
        this.prePaidTariff = prePaidTariff;
    }
}
