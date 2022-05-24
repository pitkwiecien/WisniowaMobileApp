package com.company.services;

import com.company.classes.contracts.Contract;
import com.company.classes.tariff.PostPaidTariff;
import com.company.classes.tariff.PrePaidTariff;
import com.company.classes.tariff.Tariff;
import com.company.jdbc.DatabaseConnector;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TariffService {
    public static void addTariff(Tariff tariff){
        tariff.saveToDatabase();
    }

    public static Tariff getTariffById(int id, boolean isPostPaid){
        String tableName = isPostPaid ? "post_paid_tariffs" : "pre_paid_tariffs";
        String SQL = String.format("SELECT * FROM %s WHERE id = %s LIMIT 1;", tableName, id);
        DatabaseConnector dbs = new DatabaseConnector();
        dbs.executeQuery(SQL);
        Object[] futureTariff = dbs.interpretResultSet()[0];
        if (isPostPaid) {
            try {
                return new PostPaidTariff(Double.valueOf(futureTariff[1].toString()), Integer.valueOf(futureTariff[2].toString()),
                        Integer.valueOf(futureTariff[3].toString()), Integer.valueOf(futureTariff[4].toString()),
                        Double.valueOf(futureTariff[5].toString()), Double.valueOf(futureTariff[6].toString()),
                        Double.valueOf(futureTariff[7].toString()), Double.valueOf(futureTariff[8].toString()),
                        Integer.valueOf(futureTariff[9].toString()));
            } catch (NullPointerException ignore){
                return new PostPaidTariff(Double.valueOf(futureTariff[1].toString()),
                        Integer.valueOf(futureTariff[9].toString()));
            }
        }
        else
            return new PrePaidTariff(Double.valueOf(futureTariff[1].toString()), Double.valueOf(futureTariff[2].toString()),
                    Double.valueOf(futureTariff[3].toString()), Double.valueOf(futureTariff[4].toString()),
                    Integer.valueOf(futureTariff[5].toString()));
    }
}
