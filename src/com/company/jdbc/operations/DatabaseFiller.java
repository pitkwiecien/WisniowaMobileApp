package com.company.jdbc.operations;

import com.company.classes.account.Account;
import com.company.classes.account.address.Address;
import com.company.classes.account.address.CustomerAddress;
import com.company.classes.account.customer.Company;
import com.company.classes.account.customer.Individual;
import com.company.classes.contracts.Contract;
import com.company.classes.contracts.PostPaidContract;
import com.company.classes.contracts.PrePaidContract;
import com.company.classes.model.BillingCycle;
import com.company.classes.model.addressModel.CompanyAddressType;
import com.company.classes.model.addressModel.IndividualAddressType;
import com.company.classes.tariff.PostPaidTariff;
import com.company.classes.tariff.PrePaidTariff;
import com.company.services.AccountService;
import com.company.services.ContractService;
import com.company.services.TariffService;

import java.util.Arrays;

public class DatabaseFiller {
    public static void fillDatabases(){
        Address microsoftBillingAddress = new Address("Wall Street", 12, "New York",
                "01-324");
        CustomerAddress microsoftBillingAddresses = new CustomerAddress(CompanyAddressType.BILLING,
                new Address[]{microsoftBillingAddress});
        Company microsoft = new Company("microsoft@gmail.com", BillingCycle.DAY_LAST,
                new CustomerAddress[]{microsoftBillingAddresses}, "Microsoft", "123-456-32-18", "123456785");
        Account microsofter1 = new Account("Microsofter1", "idk_bro", microsoft);
        AccountService.addAccount(microsofter1, true);




        Address googleBillingAddress = new Address("Washington Street", 14, "Los Angeles",
                "05-212");
        CustomerAddress googleBillingAddresses = new CustomerAddress(CompanyAddressType.BILLING,
                new Address[]{googleBillingAddress});
        Company google = new Company("google@wp.pl", BillingCycle.DAY_11,
                new CustomerAddress[]{googleBillingAddresses}, "Google", "435-323-13-53", "098947632");
        Account googler1 = new Account("Googler1", "password123", google);
        Account googler2 = new Account("Googler2", "password231", google);
        AccountService.addAccount(googler1, true);
        AccountService.addAccount(googler2);



        Address johnAddress = new Address("Aleje Jerozolimskie", 30, 6, "Warsaw",
                "09-321");
        CustomerAddress johnRegisteredAddresses = new CustomerAddress(IndividualAddressType.REGISTERED,
                new Address[]{johnAddress});
        Individual john = new Individual("john@gmail.com", BillingCycle.DAY_14,
                new CustomerAddress[]{johnRegisteredAddresses}, "john", "smith", "08546794753");
        Account johnsAccount = new Account("john2115ez", "white2115noniezle", john);
        AccountService.addAccount(johnsAccount, true);



        PrePaidTariff prePaidTariff = new PrePaidTariff(23.30, 0.03, 0.02, 1.0,
                12);
        TariffService.addTariff(prePaidTariff);
        PostPaidTariff postPaidTariff1 = new PostPaidTariff(100.0, 12);
        TariffService.addTariff(postPaidTariff1);
        PostPaidTariff postPaidTariff2 = new PostPaidTariff(100.0, 100, 30, 600,
                 30.0, 0.05, 0.4, 1.5, 24);
        TariffService.addTariff(postPaidTariff2);


        PrePaidContract prePaidContract1 = new PrePaidContract("132430432", google, 1);
        PrePaidContract prePaidContract2 = new PrePaidContract("733445559", john, 1);
        PostPaidContract postPaidContract1 = new PostPaidContract("234245341", john, 100.0, 2);
        PostPaidContract postPaidContract2 = new PostPaidContract("732448331", microsoft, 80.0, 2);
        ContractService.addContract(prePaidContract1);
        ContractService.addContract(prePaidContract2);
        ContractService.addContract(postPaidContract1);
        ContractService.addContract(postPaidContract2);
    }
}
