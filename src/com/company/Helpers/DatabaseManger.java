package com.company.Helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class DatabaseManger {
    Connection connection;
    Statement statement;


    //so we have access to statement if needed
    public Statement getStatement() {
        return statement;
    }





    public DatabaseManger(Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }





    //to create a table
    public void createStatsTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE stats (id INTEGER PRIMARY KEY, name String, wins INTEGER, losses INTEGER)");
        //making a table to for the testing

    }



    //to drop a table
    public void dropStatsTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS stats");// deletes tables for Test
    }




    //to find our entrys
    public ResultSet findAll(String table) throws SQLException {
        String formattedSql = String.format("SELECT * FROM %s", table);
        ResultSet rs = statement.executeQuery(formattedSql);
        //result sets giving info one row at a time
        return rs;
    }
}
