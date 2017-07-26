package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{

        Class.forName("org.sqlite.JDBC"); //to load in libary


        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:stats.db")) {// creating DB not Table

            Statement statement = connection.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS stats");// deletes tables for Test

            statement.executeUpdate("CREATE TABLE stats (id INTEGER PRIMARY KEY, name String, wins INTEGER, losses INTEGER)");
            //making a table to for the testing

            statement.executeUpdate("INSERT INTO stats (name, wins, losses) VALUES ('Joel', 10, 2)");
            //inserting info into table

            ResultSet rs = statement.executeQuery("SELECT * FROM stats");
            //result sets giving info one row at a time


            while (rs.next()) {

                String name = rs.getString("name");

                int wins = rs.getInt("wins");

                int losses = rs.getInt("losses");
                //printing out all the lines of info to check colume data

                System.out.printf("%s %s %s", name, wins, losses);
                        //print f lets us print varibles with (%s, var name)
            }


	    } catch (SQLException ex){//to keep the error from URL ^^^^^
            System.out.println("something went wrong");
        }
    }
}
