package com.company.jdbc;

public class Constants {
    public static String DATABASE_URL = "jdbc:sqlite:S:\\Java\\Maxim\\WisniowaMobileApp\\dataSources\\WisniowaMobile.db";
    public static String SHOW_TABLES = "SELECT name FROM sqlite_schema " +
            "WHERE type ='table' AND name NOT LIKE 'sqlite_%';";

    public static String CREATEDB_ADDRESSES = """
            create table addresses
            (
                id integer not null
                    constraint address_pk
                        primary key autoincrement,
                street_name text not null,
                building_number integer not null,
                apartment_number integer,
                town text not null,
                postal_code text not null,
                customer_address_id integer not null
                    constraint addresses__customer_addresses_fk
                        references customer_address
                            on update cascade on delete cascade
            );""";

    public static String CREATEDB_CUSTOMER_ADDRESSES = """
            create table customer_addresses
            (
                id integer not null
                    constraint customer_address_pk
                        primary key autoincrement,
                address_group_type text not null,
                company_id integer
                    constraint customer_addresses__companies_fk
                        references companies
                            on update cascade on delete cascade,
                individual_id integer
                    constraint customer_addresses__individuals_fk
                        references individuals
                            on update cascade on delete cascade
            );""";

    public static String CREATEDB_COMPANIES = """
            create table companies
            (
                id integer not null
                    constraint companies_pk
                        primary key autoincrement,
                email text not null,
                billing_cycle integer not null,
                name text not null,
                nip text not null,
                regon text not null
            );""";

    public static String CREATEDB_INDIVIDUALS = """
            create table individuals
            (
                id integer not null
                    constraint individuals_pk
                        primary key autoincrement,
                email text not null,
                billing_cycle integer not null,
                first_name text not null,
                last_name text not null,
                pesel text not null
            );""";

    public static String CREATEDB_ACCOUNTS = """
            create table accounts
            (
                id integer not null
                    constraint accounts_pk
                        primary key autoincrement,
                username text not null,
                password text not null,
                represented_company_id integer
                    constraint accounts__companies_fk
                        references companies
                            on update cascade on delete cascade,
                individual_id integer
                    constraint accounts__individuals_fk
                        references individuals
                            on update cascade on delete cascade
            );""";

    public static String CREATEDB_POST_PAID_CONTRACTS = """
            create table post_paid_contracts
            (
                id integer not null
                    constraint post_paid_contract_pk
                        primary key autoincrement,
                phone text not null,
                credit_limit real not null,
                post_paid_tariff_id int not null
                    constraint post_paid_contracts__post_paid_tariffs_fk
                        references post_paid_tariffs
                            on update cascade on delete cascade,
                company_id integer
                    constraint post_paid_contracts__companies_fk
                        references companies
                            on update cascade on delete cascade,
                individual_id integer
                    constraint post_paid_contracts__individuals_fk
                        references individuals
                            on update cascade on delete cascade
            );""";

    public static String CREATEDB_PRE_PAID_CONTRACTS = """
            create table pre_paid_contracts
            (
                id integer not null
                    constraint pre_paid_contracts_pk
                        primary key autoincrement,
                phone text not null,
                pre_paid_tariff_id int not null
                    constraint pre_paid_contracts__pre_paid_tariffs_fk
                        references pre_paid_tariffs
                            on update cascade on delete cascade,
                company_id integer
                    constraint pre_paid_contracts__companies_fk
                        references companies
                            on update cascade on delete cascade,
                individual_id integer
                    constraint pre_paid_contracts__individuals_fk
                        references individuals
                            on update cascade on delete cascade
            );""";

    public static String CREATEDB_POST_PAID_TARIFFS = """
            create table post_paid_tariffs
            (
                id integer not null
                    constraint post_paid_tariff_pk
                        primary key autoincrement,
                price real not null,
                amount_of_texts integer,
                amount_of_mms integer,
                amount_of_minutes integer,
                amount_of_cellular real,
                extra_text_price real,
                extra_minute_price real,
                extra_cellular_price real,
                duration_in_months integer not null
            );""";

    public static String CREATEDB_PRE_PAID_TARIFFS = """
            create table pre_paid_tariffs
            (
                id integer not null
                    constraint post_paid_tariff_pk
                        primary key autoincrement,
                price real not null,
                text_price real not null,
                minute_price real not null,
                cellular_price real not null,
                duration_in_months integer not null
            );""";
}