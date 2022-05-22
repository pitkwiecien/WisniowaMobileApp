package com.company.classes.account.address;

import com.company.classes.model.EntityClass;
import com.company.classes.model.addressModel.AddressTypeGroup;

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
}
