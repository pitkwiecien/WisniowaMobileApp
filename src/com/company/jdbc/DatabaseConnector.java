package com.company.jdbc;

import com.company.classes.model.TableIdentifiers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
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

    public Object[][] interpretResultSet(){
        if(resultSet == null) return null;
        int columnAmount;
        try {
            columnAmount = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        ArrayList<Object[]> objectArrayList = new ArrayList<>();
        while (true){
            Object[] currentIteration = new Object[columnAmount];
            int i = 1;
            try {
                if (!resultSet.next()) break;
                while (i <= columnAmount) {
                    currentIteration[i - 1] = resultSet.getObject(i);
                    i++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            objectArrayList.add(currentIteration);
        }
        Object[][] objectDblArray = new Object[objectArrayList.size()][];
        int i = 0;
        for(Object[] objects : objectArrayList){
            objectDblArray[i] = objects;
            i++;
        }
        return objectDblArray;
    }

    public static boolean execute(String SQL) {
        DatabaseConnector dbc = new DatabaseConnector();
        boolean ret = dbc.executeSQL(SQL);
        dbc.closeConnection();
        return ret;
    }

    public static void createTable(TableIdentifiers... tableIdentifier){
        DatabaseConnector dbc = new DatabaseConnector();
        for(TableIdentifiers identifier : tableIdentifier) {
            switch (identifier) {
                case ADDRESSES -> dbc.executeSQL(Constants.CREATEDB_ADDRESSES);
                case CUSTOMER_ADDRESSES -> dbc.executeSQL(Constants.CREATEDB_CUSTOMER_ADDRESSES);
                case COMPANIES -> dbc.executeSQL(Constants.CREATEDB_COMPANIES);
                case INDIVIDUALS -> dbc.executeSQL(Constants.CREATEDB_INDIVIDUALS);
                case ACCOUNTS -> dbc.executeSQL(Constants.CREATEDB_ACCOUNTS);
                case POST_PAID_CONTRACTS -> dbc.executeSQL(Constants.CREATEDB_POST_PAID_CONTRACTS);
                case PRE_PAID_CONTRACTS -> dbc.executeSQL(Constants.CREATEDB_PRE_PAID_CONTRACTS);
                case POST_PAID_TARIFFS -> dbc.executeSQL(Constants.CREATEDB_POST_PAID_TARIFFS);
                case PRE_PAID_TARIFFS -> dbc.executeSQL(Constants.CREATEDB_PRE_PAID_TARIFFS);
            }
        }
        dbc.closeConnection();
    }

    public static void dropTable(TableIdentifiers... tableIdentifier){
        DatabaseConnector dbc = new DatabaseConnector();
        for(TableIdentifiers identifier : tableIdentifier) {
            String SQL = "DROP TABLE IF EXISTS " + identifier.toString().toLowerCase();
            dbc.executeSQL(SQL);
        }
        dbc.closeConnection();
    }

    public static void initiateTables(){
        createTable(COMPANIES, INDIVIDUALS, POST_PAID_TARIFFS, PRE_PAID_TARIFFS, CUSTOMER_ADDRESSES,
                ADDRESSES, ACCOUNTS, POST_PAID_CONTRACTS, PRE_PAID_CONTRACTS);
    }

    public static void dropTables(){
        dropTable(COMPANIES, INDIVIDUALS, POST_PAID_TARIFFS, PRE_PAID_TARIFFS, CUSTOMER_ADDRESSES,
                ADDRESSES, ACCOUNTS, POST_PAID_CONTRACTS, PRE_PAID_CONTRACTS);
    }

    public static void resetAutoIncrement(String tableName){
        String SQL = "ALTER TABLE " + tableName + " AUTO_INCREMENT = 0;";
        execute(SQL);
    }

    public static Integer getLowestPossibleIdValue(String tableName){
        String SQL = "SELECT COUNT(*) FROM " + tableName + ";";
        DatabaseConnector dbc = new DatabaseConnector();
        dbc.executeQuery(SQL);
        String stringedArray = Arrays.toString(dbc.interpretResultSet()[0]);
        String cutString = stringedArray.substring(1, stringedArray.length() - 1);
        if(cutString.equals("ul")) return 0;
        int ret = Integer.parseInt(cutString);
        dbc.closeConnection();
        return (ret + 1);
    }
}
