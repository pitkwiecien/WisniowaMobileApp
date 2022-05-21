package com.company.classes.tariff;

public class PrePaidTariff implements Tariff {
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
}