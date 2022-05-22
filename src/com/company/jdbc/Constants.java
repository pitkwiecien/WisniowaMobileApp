package com.company.jdbc;

public class Constants {
    public static String DATABASE_URL = "jdbc:sqlite:S:\\Java\\Maxim\\WisniowaMobileApp\\dataSources\\WisniowaMobile.db";
    public static String SHOW_TABLES = "SELECT name FROM sqlite_schema " +
            "WHERE type ='table' AND name NOT LIKE 'sqlite_%';";

    public static String CREATEDB_ADDRESSES = "create table addresses\n" +
            "(\n" +
            "\tid integer not null\n" +
            "\t\tconstraint address_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\tstreet_name text not null,\n" +
            "\tbuilding_number integer not null,\n" +
            "\tapartment_number integer,\n" +
            "\ttown text not null,\n" +
            "\tpostal_code text not null\n" +
            ");\n";

    public static String CREATEDB_CUSTOMER_ADDRESSES = "create table customer_addresses\n" +
            "(\n" +
            "\tid int not null\n" +
            "\t\tconstraint customer_addresses_pk\n" +
            "\t\t\tprimary key autoincrement,\n" +
            "\taddress_type text not null,\n" +
            "\taddresses int\n" +
            "\t\tconstraint addresses\n" +
            "\t\t\treferences addresses\n" +
            "\t\t\t\ton update cascade on delete cascade\n" +
            ");\n";

    public static String CREATEDB_COMPANIES = "";

    public static String CREATEDB_INDIVIDUALS = "";

    public static String CREATEDB_ACCOUNTS = "";

    public static String CREATEDB_POST_PAID_CONTRACTS = "";

    public static String CREATEDB_PRE_PAID_CONTRACTS = "";

    public static String CREATEDB_POST_PAID_TARIFFS = "";

    public static String CREATEDB_PRE_PAID_TARIFFS = "";
}