package com.company.Model;

import com.company.Helpers.DatabaseManger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Stat {
    private int id;
    private String name;
    private int wins;
    private int losses;
    private  Statement statement;

    public Stat(String name, int wins, int losses, Statement statement) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
        this.statement = statement;
    }


    //Overriding the previous version with ID
    public Stat(String name, int wins, int losses, Statement statement, int id) {
        this(name, wins, losses, statement);
        this.id = id;
    }


        public void Save() throws SQLException {
        String formattedSql = String.format("INSERT INTO stats (name, wins, losses) VALUES ('%s', %s, %s)", name, wins, losses);
        // first %s needs ' ' cuz string and stuff

        statement.executeUpdate(formattedSql);
        //inserting info into table and saving
    }


    public void Update() throws SQLException {
        if(id == 0){
            throw new SQLException("cant update object with out id set");
            //exepctions must match in the throws
            //to keep ppl from updateing and making them save if entry doesnt exist
        }

        String formattedSql = String.format("UPDATE stats SET name = '%s', wins = %s, losses = %s WHERE id = %s", name, wins, losses, id);
        statement.executeUpdate(formattedSql);

    }

    public static List<Stat> findAll(DatabaseManger dbm) throws SQLException {
        ResultSet rs = dbm.findAll("stats");
        List<Stat> tempCollection = new ArrayList<>();
        Statement tempStatement = dbm.getStatement();

        while (rs.next()) {

            String name = rs.getString("name");
            int wins = rs.getInt("wins");
            int losses = rs.getInt("losses");
            //printing out all the lines of info to check column data


            Stat tempStat = new Stat(name, wins, losses, tempStatement, rs.getInt("id"));
            tempCollection.add(tempStat);
            //createing a way to add new entry's quickly
            //had to add rs.getINT id to get the id so we can update independent from others

//
// System.out.printf("%s %s %s", name, wins, losses);
//print f lets us print varibles with (%s, var name)
        }
        return tempCollection;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        return "Stat{" +
                "name='" + name + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}
