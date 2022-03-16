package com.company.classes.company;

import com.company.classes.common.PostPaidContract;
import com.company.classes.models.Customer;

import java.util.List;

public class CustomerCompany extends Customer {
    String nip;
    Integer representant;
    List<PostPaidContract> contracts;

    public CustomerCompany(Integer id, String name, String nip) {
        super(id, name);
        this.nip = nip;
        this.representant = null;
    }

    public CustomerCompany(Integer id, String name, List<PostPaidContract> postPaidContractList, String nip) {
        super(id, name, postPaidContractList);
        this.nip = nip;
        this.representant = null;
    }
    public CustomerCompany(Integer id, String name, String nip, Integer representant) {
        super(id, name);
        this.nip = nip;
        this.representant = representant;
    }

    public CustomerCompany(Integer id, String name, List<PostPaidContract> postPaidContractList, String nip, Integer representant) {
        super(id, name, postPaidContractList);
        this.nip = nip;
        this.representant = representant;
    }

    public List<PostPaidContract> getContracts() {
        return contracts;
    }

    public void setContracts(List<PostPaidContract> contracts) {
        this.contracts = contracts;
    }

    public String getNip() {
        return nip;
    }

    public Integer getRepresentant() {
        return representant;
    }

    public void setRepresentant(Integer representant) {
        this.representant = representant;
    }
}
