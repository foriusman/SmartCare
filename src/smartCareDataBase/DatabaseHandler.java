/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartCareDataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author -USER
 */
public class DatabaseHandler {
    private static final String url = "jdbc:sqlite:sqlite-jdbc-3.23.1.sqlite";
    private static Connection conn = null;
    private static Statement stmt = null;

  
   private static DatabaseHandler data= null;
    public DatabaseHandler(){
        createConnection();
        createUserTable();

    }
   public static DatabaseHandler getInstance(){
        if(data == null){
            data = new DatabaseHandler();
        }
        return data;
    }
  
    
    void createConnection(){
    try{
        Class.forName("org.sqlite.JDBC").newInstance();
        conn = DriverManager.getConnection(url);
        stmt = conn.createStatement();
        System.out.println("Connectin Successful");
        }
    catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
  

void createUserTable(){
      try{  // String sql= "drop table userTable";
                String sql= "create table userTable("+ 
                  "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                  "userId varchar(30) NOT NULL, "+
                  "username varchar(30) NOT NULL, "+
                  "password varchar(22) NOT NULL, "+               
                  "userportfolio varchar(30) NOT NULL,"+
                  "bioimg longblob,"+
                  "date TIMESTAMP NOT NULL DEFAULT current_timestamp)";
          stmt.executeUpdate(sql);
          System.out.println("User Table created");
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
  }


      
  public ResultSet executeQuery(String sql){
        ResultSet result = null;
        try{
             result  = stmt.executeQuery(sql);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }
     public boolean executeAction(PreparedStatement preparedStatement) {
        try {
            boolean r = preparedStatement.execute();
            System.out.println("value from prepared " + r);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   

    public PreparedStatement createPreparedStatements(String sql) {

        try {
            return conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 public boolean executeAction2(String sql){
      try{
          stmt.execute(sql);
                return true;
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
          return false;
      }
  }    
    public ResultSet executeQuery2(String sql){
        ResultSet result = null;
        try{
             result  = stmt.executeQuery(sql);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}
