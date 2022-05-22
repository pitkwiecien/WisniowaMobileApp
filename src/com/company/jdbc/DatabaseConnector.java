package com.company.jdbc;

import com.company.classes.model.TableIdentifiers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.company.classes.model.TableIdentifiers.*;

public class DatabaseConnector {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public DatabaseConnector() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        openConnection();
    }

    public void closeConnection(){
        try {
            Objects.requireNonNull(connection).close();
            Objects.requireNonNull(resultSet).close();
            Objects.requireNonNull(statement).close();
        } catch (Exception ignore) {
        }
    }

    public void openConnection(){
        if(connection != null) {
            try {
                closeConnection();
            } catch (ConnectionAbsenceException ignored) {

            }
        }
        try {
            String url = Constants.DATABASE_URL;
            connection = DriverManager.getConnection(url);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean executeQuery(String query){
        if (connection == null) throw new ConnectionAbsenceException();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean executeSQL(String SQL){
        if (connection == null) throw new ConnectionAbsenceException();
        boolean eq = false;
        try {
            statement = connection.createStatement();
            eq = statement.execute(SQL);
        } catch (Exception ignore){}
        return eq;
    }

    public Object[] interpretResultSet(){
        if(resultSet == null) return null;
        List<Object> objectList = new ArrayList<>();
        int i = 1;
        while (true){
            try {
                if (!resultSet.next()) break;
                objectList.add(resultSet.getObject(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            i++;
        }
        return objectList.toArray();
    }

    public static boolean execute(String SQL) {
        DatabaseConnector dbc = new DatabaseConnector();
        boolean ret = dbc.executeQuery(SQL);
        dbc.closeConnection();
        return ret;
    }

    public static void createTable(TableIdentifiers... tableIdentifier){
        for(TableIdentifiers identifier : tableIdentifier) {
            switch (identifier) {
                case ADDRESSES -> execute(Constants.CREATEDB_ADDRESSES);
                case CUSTOMER_ADDRESSES -> execute(Constants.CREATEDB_CUSTOMER_ADDRESSES);
                case COMPANIES -> execute(Constants.CREATEDB_COMPANIES);
                case INDIVIDUALS -> execute(Constants.CREATEDB_INDIVIDUALS);
                case ACCOUNTS -> execute(Constants.CREATEDB_ACCOUNTS);
                case POST_PAID_CONTRACTS -> execute(Constants.CREATEDB_POST_PAID_CONTRACTS);
                case PRE_PAID_CONTRACTS -> execute(Constants.CREATEDB_PRE_PAID_CONTRACTS);
                case POST_PAID_TARIFFS -> execute(Constants.CREATEDB_POST_PAID_TARIFFS);
                case PRE_PAID_TARIFFS -> execute(Constants.CREATEDB_PRE_PAID_TARIFFS);
            }
        }
    }

    public static void initiateTables(){
        createTable(ADDRESSES, CUSTOMER_ADDRESSES, COMPANIES, INDIVIDUALS, ACCOUNTS, POST_PAID_CONTRACTS, PRE_PAID_CONTRACTS,
                POST_PAID_TARIFFS, PRE_PAID_TARIFFS);
    }
}
