package com.company.classes.tariff;

import com.company.classes.model.EntityClass;
import com.company.jdbc.DatabaseConnector;

public class PostPaidTariff implements Tariff, EntityClass {
    private Double price;
    private Integer amountOfTexts;
    private Integer amountOfMMS;
    private Integer amountOfMinutes;
    private Double amountOfCellular;
    private Double extraTextPrice;
    private Double extraMinutePrice;
    private Double extraCellularPrice;
    private Integer durationInMonths;

    public PostPaidTariff(Double price, Integer amountOfTexts, Integer amountOfMMS, Integer amountOfMinutes, Double amountOfCellular, Double extraTextPrice, Double extraMinutePrice, Double extraCellularPrice, Integer durationInMonths) {
        this.price = price;
        this.amountOfTexts = amountOfTexts;
        this.amountOfMMS = amountOfMMS;
        this.amountOfMinutes = amountOfMinutes;
        this.amountOfCellular = amountOfCellular;
        this.extraTextPrice = extraTextPrice;
        this.extraMinutePrice = extraMinutePrice;
        this.extraCellularPrice = extraCellularPrice;
        this.durationInMonths = durationInMonths;
    }

    public PostPaidTariff(Double price, Integer durationInMonths) {
        this.price = price;
        this.amountOfTexts = null;
        this.amountOfMMS = null;
        this.amountOfMinutes = null;
        this.amountOfCellular = null;
        this.extraTextPrice = null;
        this.extraMinutePrice = null;
        this.extraCellularPrice = null;
        this.durationInMonths = durationInMonths;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getAmountOfTexts() {
        return amountOfTexts;
    }

    public Integer getAmountOfMMS() {
        return amountOfMMS;
    }

    public Integer getAmountOfMinutes() {
        return amountOfMinutes;
    }

    public Double getAmountOfCellular() {
        return amountOfCellular;
    }

    public Double getExtraTextPrice() {
        return extraTextPrice;
    }

    public Double getExtraMinutePrice() {
        return extraMinutePrice;
    }

    public Double getExtraCellularPrice() {
        return extraCellularPrice;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void saveToDatabase() {
        String SQL = String.format("INSERT INTO post_paid_tariffs(price, amount_of_texts, amount_of_mms, amount_of_minutes, " +
                "amount_of_cellular, extra_text_price, extra_minute_price, extra_cellular_price, duration_in_months)" +
                "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s);", price, amountOfTexts, amountOfMMS, amountOfMinutes,
                amountOfCellular, extraTextPrice, extraMinutePrice, extraCellularPrice, durationInMonths);
        DatabaseConnector.execute(SQL);
    }
}
