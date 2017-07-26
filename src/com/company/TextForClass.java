//package com.company;
//
//
//import com.company.Helpers.DatabaseManger;
//import com.company.Model.Stat;
//
//import java.sql.Statement;
//import java.util.List;
//
//public class TextForClass {
//
//
//    DatabaseManger db = new DatabaseManger(connection); //helpers
//            db.dropStatsTable();//look to helpers
//            db.createStatsTable();//look to helpers
//    Statement statement = db.getStatement(); //helpers
//
//
//
//    Stat joelStat = new Stat("Peanut", 3, 10, statement); //look to stat
//            joelStat.Save(); //writeing a table entry based off a function like thing in stat
//
//    Stat joeMontana = new Stat("Joel Montana",750,2, statement);
//            joeMontana.Save();
//
//
//
//
//
//    List<Stat> results =Stat.findAll(db); //Stat folder
//            for (Stat stat: results) {
//        //set all "wins" to 0 then update all rows
//        //System.out.println(stat);
//        stat.setWins(0);
//        stat.Update();
//    }
//
//    results = Stat.findAll(db); //Stat folder
//            for (Stat stat: results) {
//        System.out.println(stat);
//    }
//
//
//}
