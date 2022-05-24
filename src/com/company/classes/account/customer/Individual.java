package com.company.classes.account.customer;

import com.company.classes.account.address.Address;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.EntityClass;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.jdbc.DatabaseConnector;

public class Individual extends Customer implements EntityClass {
    public static Integer unsavedObjectNumber = 0;
    private Integer id;
    private String firstName;
    private String lastName;
    private String pesel;

    public Individual(String email, BillingCycle billingCycle, String firstName, String lastName, String pesel) {
        super(email, billingCycle);
        this.id = DatabaseConnector.getLowestPossibleIdValue("individuals") + unsavedObjectNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        unsavedObjectNumber++;
    }

    public Individual(String email, BillingCycle billingCycle, CustomerAddress[] customerAddresses, String firstName,
                      String lastName, String pesel) {
        super(email, billingCycle, customerAddresses);
        this.id = DatabaseConnector.getLowestPossibleIdValue("individuals") + unsavedObjectNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        unsavedObjectNumber++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void saveToDatabase() {
        String SQL = String.format("INSERT INTO individuals(id, email, billing_cycle, first_name, last_name, pesel) VALUES" +
                "(%s, \"%s\", %s, \"%s\", \"%s\", \"%s\");", id, getEmail(), getBillingCycle().toInt(),
                firstName, lastName, pesel);
        DatabaseConnector.execute(SQL);
        unsavedObjectNumber--;
    }
}
