package com.company.Helpers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DatabaseManger {

    Connection connection;
    Statement statement;

    public Statement getStatement() {
        return statement;
    }


    public DatabaseManger(Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }

    public void createStatsTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE stats (id INTEGER PRIMARY KEY, name String, wins INTEGER, losses INTEGER)");
        //making a table to for the testing

    }

    public void dropStatsTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS stats");// deletes tables for Test
    }

    public ResultSet findAll(String table) throws SQLException {
        String formattedSql = String.format("SELECT * FROM %s", table);
        ResultSet rs = statement.executeQuery(formattedSql);
        //result sets giving info one row at a time
        return rs;
    }
}
