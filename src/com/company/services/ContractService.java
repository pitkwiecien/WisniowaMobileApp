package com.company.services;

import com.company.classes.contracts.Contract;
import com.company.classes.contracts.PostPaidContract;
import com.company.classes.contracts.PrePaidContract;
import com.company.jdbc.DatabaseConnector;

import java.util.ArrayList;
import java.util.List;

public class ContractService {
    public static void addContract(Contract contract){
        contract.saveToDatabase();
    }

    public static Contract[] getContractsByCustomerId(Integer customerId, Boolean isCompany){
        String SQL_PostPaid;
        String SQL_PrePaid;
        Object[][] PostPaids;
        Object[][] PrePaids;
        List<Contract> returningList = new ArrayList<>();
        if(isCompany){
            SQL_PrePaid = "SELECT pre_paid_contracts.* FROM pre_paid_contracts JOIN " +
                    "companies c on pre_paid_contracts.company_id = c.id WHERE c.id = " + customerId + ";";
            SQL_PostPaid = "SELECT post_paid_contracts.* FROM post_paid_contracts JOIN " +
                    "companies c on c.id = post_paid_contracts.company_id WHERE c.id = " + customerId + ";";
        } else {
            SQL_PrePaid = "SELECT pre_paid_contracts.* FROM pre_paid_contracts JOIN " +
                    "individuals i on pre_paid_contracts.individual_id = i.id WHERE i.id = " + customerId + ";";
            SQL_PostPaid = "SELECT post_paid_contracts.* FROM post_paid_contracts JOIN " +
                    "individuals i on post_paid_contracts.individual_id = i.id WHERE i.id = " + customerId + ";";
        }
        DatabaseConnector dbc_PrePaid = new DatabaseConnector();
        dbc_PrePaid.executeQuery(SQL_PrePaid);
        PrePaids = dbc_PrePaid.interpretResultSet();
        dbc_PrePaid.closeConnection();
        for(Object[] row : PrePaids){
            returningList.add(new PrePaidContract(row[1].toString(), CustomerService.getCustomerById(customerId, isCompany), Integer.valueOf(row[2].toString())));
        }

        DatabaseConnector dbc_PostPaid = new DatabaseConnector();
        dbc_PostPaid.executeQuery(SQL_PostPaid);
        PostPaids = dbc_PostPaid.interpretResultSet();
        for(Object[] row : PostPaids){
            returningList.add(new PostPaidContract(row[1].toString(), CustomerService.getCustomerById(customerId, isCompany), Double.valueOf(row[2].toString()),
                    Integer.valueOf(row[3].toString())));
        }
        return returningList.toArray(new Contract[0]);
    }
}
