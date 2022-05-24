package com.company.classes.contracts;

import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Customer;
import com.company.classes.account.customer.Individual;
import com.company.classes.model.EntityClass;
import com.company.classes.tariff.PrePaidTariff;
import com.company.jdbc.DatabaseConnector;

public class PrePaidContract extends Contract implements EntityClass {
    private Integer prePaidTariffId;

    public PrePaidContract(String phone, Customer customer, Integer prePaidTariffId) {
        super(phone, customer);
        this.prePaidTariffId = prePaidTariffId;
    }

    public Integer getPrePaidTariffId() {
        return prePaidTariffId;
    }

    public void saveToDatabase() {
        Integer companyId = null;
        Integer individualId = null;
        if(getCustomer() instanceof Company) companyId = getCustomer().getId();
        else individualId = getCustomer().getId();
        String SQL = String.format("INSERT INTO pre_paid_contracts(phone, pre_paid_tariff_id, company_id, individual_id)" +
                " VALUES (\"%s\", %s, %s, %s);", getPhone(), prePaidTariffId, companyId, individualId);
        DatabaseConnector.execute(SQL);
    }
}
