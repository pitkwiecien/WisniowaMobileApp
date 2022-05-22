package com.company.classes.contracts;

import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Individual;
import com.company.classes.model.EntityClass;
import com.company.classes.tariff.PrePaidTariff;
import com.company.jdbc.DatabaseConnector;

public class PrePaidContract extends Contract implements EntityClass {
    private Integer prePaidTariffId;

    public PrePaidContract(String phone, Integer prePaidTariffId, Integer creatorId, Boolean creatorIsCompany) {
        super(phone, creatorId, creatorIsCompany);
        this.prePaidTariffId = prePaidTariffId;
    }

    public Integer getPrePaidTariffId() {
        return prePaidTariffId;
    }

    public void saveToDatabase() {
        String SQL = String.format("INSERT INTO pre_paid_contracts(phone, pre_paid_tariff_id, company_id, individual_id)" +
                " VALUES (\"%s\", %s, %s, %s);", getPhone(), prePaidTariffId, getCompanyId(), getIndividualId());
        DatabaseConnector.execute(SQL);
    }
}
