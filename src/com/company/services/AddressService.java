package com.company.services;

import com.company.classes.account.address.Address;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.model.addressModel.AddressTypeGroup;
import com.company.classes.model.addressModel.CompanyAddressType;
import com.company.classes.model.addressModel.IndividualAddressType;
import com.company.jdbc.DatabaseConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddressService {
    public static void addAddress(Address address, Integer customerAddressId){
        address.saveToDatabase(customerAddressId);
    }

    public static void addCustomerAddress(CustomerAddress address, Integer customerId, Boolean isCompany){
        ArrayList<Address> addresses = (ArrayList<Address>) address.getAddresses();
        if (addresses == null) return;
        address.saveToDatabase(customerId, isCompany);
        for(Address addressObject : addresses)
            AddressService.addAddress(addressObject, address.getId());
    }

    public static Address getAddressById(int id){
        String SQL = "SELECT * FROM addresses WHERE id = " + id + " LIMIT 1;";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[] futureAddress = dbc.interpretResultSet()[0];
        return new Address((String) futureAddress[1], Integer.parseInt(futureAddress[2].toString()),
                Integer.parseInt(futureAddress[2].toString()), (String) futureAddress[3], (String) futureAddress[4]);
    }

    public static Address[] getAddressesByCustomerAddressId(int id){
        ArrayList<Address> addressArrayList = new ArrayList<>();
        String SQL = "SELECT addresses.* FROM addresses JOIN customer_addresses on addresses.customer_address_id = " +
                "customer_addresses.id WHERE customer_addresses.id = 1 LIMIT 1;";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[][] result = dbc.interpretResultSet();
        for(Object[] row : result){
            addressArrayList.add(new Address((String) row[1], Integer.parseInt(row[2].toString()),
                    Integer.parseInt(row[2].toString()), (String) row[3], (String) row[4]));
        }
        return addressArrayList.toArray(new Address[0]);
    }

    public static CustomerAddress getCustomerAddressById(int id) {
        String SQL = "SELECT * FROM customer_addresses WHERE id = " + id + " LIMIT 1;";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[] futureCustomerAddress = dbc.interpretResultSet()[0];
        String futureAddressGroupType = futureCustomerAddress[1].toString();
        boolean isCompany = futureCustomerAddress[2] != null;
        AddressTypeGroup addressTypeGroup;
        if(isCompany) {
            addressTypeGroup = CompanyAddressType.valueOf(futureAddressGroupType);
        } else {
            addressTypeGroup = IndividualAddressType.valueOf(futureAddressGroupType);
        }
        Address[] addresses = getAddressesByCustomerAddressId(id);
        return new CustomerAddress(addressTypeGroup, addresses);
    }

    public static CustomerAddress[] getCustomerAddressesByCustomerId(int id, boolean isCompany){
        ArrayList<CustomerAddress> customerAddressArrayList = new ArrayList<>();
        String SQL;
        if(isCompany)
            SQL = "SELECT customer_addresses.* FROM customer_addresses JOIN companies c " +
                "on customer_addresses.company_id = c.id WHERE c.id = " + id + " LIMIT 1;";
        else
            SQL = "SELECT customer_addresses.* FROM customer_addresses JOIN individuals i " +
                    "on customer_addresses.individual_id = i.id WHERE i.id = " + id + " LIMIT 1;";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        Object[][] result = dbc.interpretResultSet();
        for(Object[] row : result){
            AddressTypeGroup addressTypeGroup;
            String futureAddressGroupType = row[1].toString();
            if(isCompany) {
                addressTypeGroup = CompanyAddressType.valueOf(futureAddressGroupType);
            } else {
                addressTypeGroup = IndividualAddressType.valueOf(futureAddressGroupType);
            }
            customerAddressArrayList.add(new CustomerAddress(addressTypeGroup,
                    getAddressesByCustomerAddressId(Integer.parseInt(row[0].toString()))));
        }
        return customerAddressArrayList.toArray(new CustomerAddress[0]);
    }
}
