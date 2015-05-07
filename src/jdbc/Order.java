/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Александр
 */
public class Order {
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
  static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
  
  static final String USER = "root";
   static final String PASS = "kzevyetf";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  Connection conn = null;
  Statement stl = null;
  try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connection to Database");
      
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      
      System.out.println("QUERY:");
      stl = conn.createStatement();
      String sql;
      sql = "SELECT userName FROM userTWO";
      ResultSet rs = stl.executeQuery(sql);
      while(rs.next()){
          String name =rs.getNString("userName");
          System.out.println(name);
      }
      rs.close();
      stl.close();
      conn.close();
  }
  catch (SQLException e){
      e.printStackTrace();
  }
  catch (Exception e){
      e.printStackTrace();
  }
  finally{
      
      try{
         if(stl!=null)
            stl.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
      
  }
    
}}
