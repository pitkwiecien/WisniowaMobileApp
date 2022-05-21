package com.company.classes.account.address;

public class Address {
    private String streetName;
    private Integer buildingNumber;
    private Integer apartmentNumber;
    private String town;
    private String postalCode;

    public Address(String streetName, Integer buildingNumber, Integer apartmentNumber, String town, String postalCode) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.town = town;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public String getTown() {
        return town;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
