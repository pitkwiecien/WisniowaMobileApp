package com.company.classes.tariff;

import com.company.classes.model.EntityClass;
import com.company.jdbc.DatabaseConnector;

public class PrePaidTariff implements Tariff, EntityClass {
    private Double price;
    private Double textPrice;
    private Double minutePrice;
    private Double cellularPrice;
    private Integer durationInMonths;

    public PrePaidTariff(Double price, Double textPrice, Double minutePrice, Double cellularPrice, Integer durationInMonths) {
        this.price = price;
        this.textPrice = textPrice;
        this.minutePrice = minutePrice;
        this.cellularPrice = cellularPrice;
        this.durationInMonths = durationInMonths;
    }

    public Double getPrice() {
        return price;
    }

    public Double getTextPrice() {
        return textPrice;
    }

    public Double getMinutePrice() {
        return minutePrice;
    }

    public Double getCellularPrice() {
        return cellularPrice;
    }

    public Integer getDurationInMonths() {
        return durationInMonths;
    }

    public void saveToDatabase() {
        String SQL = String.format("INSERT INTO pre_paid_tariffs(price, text_price, minute_price, cellular_price, " +
                "duration_in_months) VALUES (%s, %s, %s, %s, %s);", price, textPrice, minutePrice, cellularPrice,
                durationInMonths);
        DatabaseConnector.execute(SQL);
    }
}
