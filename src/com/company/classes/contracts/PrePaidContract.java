package com.company.classes.contracts;

import com.company.classes.model.EntityClass;
import com.company.classes.tariff.PrePaidTariff;
import com.company.jdbc.DatabaseConnector;

public class PrePaidContract extends Contract implements EntityClass {
    private PrePaidTariff prePaidTariff;

    public PrePaidContract(String phone, PrePaidTariff prePaidTariff) {
        super(phone);
        this.prePaidTariff = prePaidTariff;
    }

    public PrePaidTariff getPrePaidTariff() {
        return prePaidTariff;
    }
}
