/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alihaydar
 */
public class DBHelper {
    private static Statement st;
   private static ResultSet rs;
   private static PreparedStatement ps;
   private static Connection con =null;
   
    public static Connection getConnection(){
        String url="jdbc:postgresql://localhost:5432/postgres";
        String user="postgres";
        String password="1234";
        
        try {
            
            Class.forName("org.postgresql.Driver").newInstance();
            System.out.println("baglantı basarili");
             con=DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
       return con;
    }
    
    public static ResultSet ExecuteScalar(String query) throws SQLException
    {
         if ( con == null)
                 con =getConnection();
         if (con.isClosed())
              con =getConnection();
         try
         {
            ps=con.prepareStatement(query);
            rs=ps.executeQuery();    
         }
         catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
         return rs;
    }
        public static Boolean  ExecuteNonQuery(String query) throws SQLException
    {
         if ( con == null)
                 con =getConnection();
         if (con.isClosed())
              con =getConnection();
         try
         {
            ps=con.prepareStatement(query);
            ps.execute();  
            return true;
         }
         catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } 
        
    }
}
