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


            WelcomeMenu();//down below calling 

        } catch (SQLException ex) {//to keep the error from URL ^^^^^
            System.out.println("something went wrong");
            ex.printStackTrace();
        }
    }

    public static void WelcomeMenu() {
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
                break;
            case 2:
                System.out.println("tell me some info about your stat person thing");
                break;
            case 3:
                System.out.println("Which player name would you like to update");
                break;
            default:
                System.out.println("invalid input");
        }
        WelcomeMenu();
    }
}

