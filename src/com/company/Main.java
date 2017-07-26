package com.company;

import com.company.Helpers.DatabaseManger;
import com.company.Model.Stat;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{

        Class.forName("org.sqlite.JDBC"); //to load in libary


        try(Connection connection = DriverManager.getConnection("jdbc:sqlite:stats.db")) {// creating DB not Table
            //text for class has use building a dummy table to play around with check there



            //created database
            DatabaseManger dbm = new DatabaseManger(connection);
            WelcomeMenu(dbm);//down below calling



        }catch (SQLException ex) {//to keep the error from URL ^^^^^
            System.out.println("something went wrong");
            ex.printStackTrace();
        }
    }

    public static void WelcomeMenu(DatabaseManger dbm) throws SQLException {
        //limiting users options
        System.out.println("=========================================================");
        System.out.println("Welcome to Stat Database 3000. What would you like to do?");
        System.out.println("1) Show All Stats");
        System.out.println("2) Add a new Stat");
        System.out.println("3) Update an Existing Stat");
        System.out.println("=========================================================");

        //take the users input for switch
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        //filters thru user inputs and does so and so if blank
        switch (choice){
            case 1:
                System.out.println("now showing all stats");
                List<Stat> results = Stat.findAll(dbm);
                for (Stat stat : results){
                    System.out.println(stat);
                }
                break;

            case 2:
                System.out.println("players name");
                String name = scanner.next();
                System.out.println("how many wins");
                int wins = scanner.nextInt();
                System.out.println("how many losses");
                int losses = scanner.nextInt();
                //saving all the info
                new Stat(name, wins, losses, dbm.getStatement()).Save();
                break;

            case 3:
                System.out.println("Which player name would you like to update");
                String currentName = scanner.next();
                Stat searchName = Stat.findByName(dbm, dbm.getStatement(), currentName);

                if (searchName == null) {
                    System.out.println("not in the system");
                    WelcomeMenu(dbm);
                }
                System.out.println("players new name?");
                String newName = scanner.next();
                System.out.println("new wins?");
                int newWins = scanner.nextInt();
                System.out.println("new losses?");
                int newLosses = scanner.nextInt();

                searchName.setName(newName);
                searchName.setWins(newWins);
                searchName.setLosses(newLosses);
                searchName.Update();
                System.out.println("entry updated");

                break;
            default:
                System.out.println("invalid input");
        }
        WelcomeMenu(dbm);
    }
}

