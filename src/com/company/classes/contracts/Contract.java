package com.company.classes.contracts;

public abstract class Contract {
    private String phone;
    private Integer companyId;
    private Integer individualId;

    public Contract(String phone, Integer creatorId, Boolean creatorIsCompany) {
        this.companyId = null;
        this.individualId = null;
        if(creatorIsCompany) this.companyId = creatorId;
        else this.individualId = creatorId;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public Integer getIndividualId() {
        return individualId;
    }
}
