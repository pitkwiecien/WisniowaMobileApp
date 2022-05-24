package com.company.classes.account.address;

import com.company.classes.model.EntityClass;
import com.company.jdbc.DatabaseConnector;

public class Address implements EntityClass {
    private String streetName;
    private Integer buildingNumber;
    private Integer apartmentNumber;
    private String town;
    private String postalCode;

    public Address(String streetName, Integer buildingNumber, String town, String postalCode) {
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.town = town;
        this.postalCode = postalCode;
    }

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

    public void saveToDatabase(Integer customerAddressId) {
        String SQL = String.format("INSERT INTO addresses(street_name, building_number, apartment_number, " +
                "town, postal_code, customer_address_id) VALUES (\"%s\", %s, %s, \"%s\", \"%s\", %s);",
                streetName, buildingNumber, apartmentNumber, town, postalCode, customerAddressId);
        DatabaseConnector.execute(SQL);
    }
}
