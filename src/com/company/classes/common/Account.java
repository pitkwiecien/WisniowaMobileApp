package com.company.classes.common;

import com.company.classes.models.Contract;

import java.util.List;
import java.util.Map;

public class Account {
    Integer id;
    String username;
    String passwordHash;
    Integer representedCompanyId;
    List<Map<String, Contract>> phoneToContractMap;

    public Account(Integer id, String username, String passwordHash, Integer representedCompanyId) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.representedCompanyId = representedCompanyId;
    }

    public Account(Integer id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

}
