package com.company.classes.common;

import com.company.classes.company.CustomerCompany;

public class Account {
    Integer id;
    String username;
    String passwordHash;
    Integer representedCompany;
    List<>

    public Account(Integer id, String username, String passwordHash) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public Account(Integer id, String username, String passwordHash, Integer representedCompany) {
        this.id = id;
        this.username = username;
        this.passwordHash = passwordHash;
        this.representedCompany = representedCompany;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Integer getRepresentedCompany() {
        return representedCompany;
    }

    public void setRepresentedCompany(Integer representedCompany) {
        this.representedCompany = representedCompany;
    }
}
