/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tanni
 */
import java.sql.*;
import javax.swing.*;

public class DBConnect {
    Connection conn = null;
       public static Connection connectDb(){
           try{
               Class.forName("org.sqlite.JDBC");
              // .newInstance()
               Connection conn =DriverManager.getConnection("jdbc:sqlite:E:\\Project\\project\\project.sqlite");
              // System.out.println("Connection Success");
               JOptionPane.showMessageDialog(null,"Connection Success");
               return conn;
           }catch(Exception e){
               JOptionPane.showMessageDialog(null, e);
               return null;
           }
           //String url = "jdbc:mysql://localhost:3306/librarymansys";
}
}