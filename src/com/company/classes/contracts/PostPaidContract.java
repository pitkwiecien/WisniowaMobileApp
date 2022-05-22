package com.company.classes.contracts;

import com.company.classes.model.EntityClass;
import com.company.classes.tariff.PostPaidTariff;
import com.company.jdbc.DatabaseConnector;

public class PostPaidContract extends Contract implements EntityClass {
    private Double creditLimit;
    private Integer postPaidTariffId;

    public PostPaidContract(String phone, Double creditLimit, Integer postPaidTariffId, Integer creatorId,
                            Boolean creatorIsCompany) {
        super(phone, creatorId, creatorIsCompany);
        this.creditLimit = creditLimit;
        this.postPaidTariffId = postPaidTariffId;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public Integer getPostPaidTariffId() {
        return postPaidTariffId;
    }

    public void saveToDatabase() {
        String SQL = String.format("INSERT INTO post_paid_contracts(phone, credit_limit, post_paid_tariff_id, company_id," +
                "individual_id) VALUES (\"%s\", %s, %s, %s, %s);", getPhone(), creditLimit, postPaidTariffId,
                getCompanyId(), getIndividualId());
        DatabaseConnector.execute(SQL);
    }
}