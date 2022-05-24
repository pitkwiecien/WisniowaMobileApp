package com.company.classes.contracts;

import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Customer;
import com.company.classes.model.EntityClass;
import com.company.classes.tariff.PostPaidTariff;
import com.company.jdbc.DatabaseConnector;

public class PostPaidContract extends Contract implements EntityClass {
    private Double creditLimit;
    private Integer postPaidTariffId;

    public PostPaidContract(String phone, Customer customer, Double creditLimit, Integer postPaidTariffId) {
        super(phone, customer);
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
        Integer companyId = null;
        Integer individualId = null;
        if(getCustomer() instanceof Company) companyId = getCustomer().getId();
        else individualId = getCustomer().getId();
        String SQL = String.format("INSERT INTO post_paid_contracts(phone, credit_limit, post_paid_tariff_id, company_id," +
                "individual_id) VALUES (\"%s\", %s, %s, %s, %s);", getPhone(), creditLimit, postPaidTariffId,
                companyId, individualId);
        DatabaseConnector.execute(SQL);
    }
}