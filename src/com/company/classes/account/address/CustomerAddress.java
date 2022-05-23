package com.company.classes.account.address;

import com.company.classes.model.EntityClass;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.jdbc.DatabaseConnector;

import java.util.ArrayList;
import java.util.List;

public class CustomerAddress implements EntityClass {
    private List<Address> addresses;
    private AddressTypeGroup addressType;

    public CustomerAddress(AddressTypeGroup addressType) {
        this.addressType = addressType;
        addresses = new ArrayList<>();
    }

    public CustomerAddress(AddressTypeGroup addressType, Address address) {
        this.addressType = addressType;
        addresses = new ArrayList<>();
        addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public AddressTypeGroup getAddressType() {
        return addressType;
    }

    public void saveToDatabase(Integer customerId, Boolean isCompany) {
        Integer companyId = null;
        Integer individualId = null;
        if(isCompany) companyId = customerId;
        else individualId = customerId;
        String SQL = String.format("\"INSERT INTO customer_addresses(address_group_type, company_id, individual_id)" +
                " VALUES (\"%s\", %s, %s);", addressType, companyId, individualId);
        DatabaseConnector.execute(SQL);
    }


}
