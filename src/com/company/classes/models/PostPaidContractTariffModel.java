package com.company.classes.models;

import com.company.classes.common.Tariff;

public class PostPaidContractTariffModel extends Tariff {
    Integer maxPhoneMinutes;
    Integer maxSms;
    Integer maxMms;

    public PostPaidContractTariffModel(Integer id, Integer maxPhoneMinutes, Integer maxSms, Integer maxMms, Double priceForOldCustomers, Double priceForNewCustomers) {
        super(id, priceForNewCustomers);
        this.maxPhoneMinutes = maxPhoneMinutes;
        this.maxSms = maxSms;
        this.maxMms = maxMms;
    }

    public PostPaidContractTariffModel(Integer id, Integer maxPhoneMinutes, Integer maxSms, Integer maxMms, Double price) {
        this.id = id;
        this.maxPhoneMinutes = maxPhoneMinutes;
        this.maxSms = maxSms;
        this.maxMms = maxMms;
        this.priceForOldCustomers = price;
        this.priceForNewCustomers = price;
    }

    public Integer getId() {
        return id;
    }

    public Integer getMaxPhoneMinutes() {
        return maxPhoneMinutes;
    }

    public void setMaxPhoneMinutes(Integer maxPhoneMinutes) {
        this.maxPhoneMinutes = maxPhoneMinutes;
    }

    public Integer getMaxSms() {
        return maxSms;
    }

    public void setMaxSms(Integer maxSms) {
        this.maxSms = maxSms;
    }

    public Integer getMaxMms() {
        return maxMms;
    }

    public void setMaxMms(Integer maxMms) {
        this.maxMms = maxMms;
    }

    public Double getPriceForOldCustomers() {
        return priceForOldCustomers;
    }

    public void setPriceForOldCustomers(Double priceForOldCustomers) {
        this.priceForOldCustomers = priceForOldCustomers;
    }

    public Double getPriceForNewCustomers() {
        return priceForNewCustomers;
    }

    public void setPriceForNewCustomers(Double priceForNewCustomers) {
        this.priceForNewCustomers = priceForNewCustomers;
    }
}
