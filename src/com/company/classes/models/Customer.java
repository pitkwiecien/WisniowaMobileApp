package com.company.classes.models;

import com.company.classes.common.PostPaidContract;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    Integer id;
    String name;
    List<PostPaidContract> postPaidContractList;

    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
        postPaidContractList = new ArrayList<PostPaidContract>();
    }

    public Customer(Integer id, String name, List<PostPaidContract> postPaidContractList) {
        this.id = id;
        this.name = name;
        this.postPaidContractList = postPaidContractList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public List<PostPaidContract> getContractList() {
        return postPaidContractList;
    }

    public void setContractList(List<PostPaidContract> postPaidContractList) {
        this.postPaidContractList = postPaidContractList;
    }
}
