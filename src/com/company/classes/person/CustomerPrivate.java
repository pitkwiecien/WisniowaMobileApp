package com.company.classes.person;

import com.company.classes.models.Customer;
import com.company.classes.common.PostPaidContract;

import java.util.List;

public class CustomerPrivate extends Customer {
    public CustomerPrivate(Integer id, String name) {
        super(id, name);
    }

    public CustomerPrivate(Integer id, String name, List<PostPaidContract> postPaidContractList) {
        super(id, name, postPaidContractList);
    }
}
