package com.company.classes.account.address;

import com.company.classes.model.EntityClass;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.jdbc.DatabaseConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerAddress implements EntityClass {
    public static Integer unsavedObjectNumber = 0;
    private Integer id;
    private List<Address> addresses;
    private AddressTypeGroup addressType;

    public CustomerAddress(AddressTypeGroup addressType, Address[] addresses) {
        this.id = DatabaseConnector.getLowestPossibleIdValue("customer_addresses") + unsavedObjectNumber;
        this.addressType = addressType;
        this.addresses = new ArrayList<>();
        this.addresses.addAll(Arrays.asList(addresses));
        unsavedObjectNumber++;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public AddressTypeGroup getAddressType() {
        return addressType;
    }

    public Integer getId() {
        return id;
    }

    public void saveToDatabase(Integer customerId, Boolean isCompany) {
        Integer companyId = null;
        Integer individualId = null;
        if(isCompany) companyId = customerId;
        else individualId = customerId;
        String SQL = String.format("INSERT INTO customer_addresses(address_group_type, company_id, individual_id)" +
                " VALUES (\"%s\", %s, %s);", addressType, companyId, individualId);
        DatabaseConnector.execute(SQL);
        unsavedObjectNumber--;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "id=" + id +
                ", addresses=" + addresses +
                ", addressType=" + addressType +
                '}';
    }
}
