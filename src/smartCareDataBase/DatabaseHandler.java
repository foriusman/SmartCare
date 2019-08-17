/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartCareDataBase;

import Administrator.StaffRecordUIController;
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
        createStaffTable();
        createNotice();
        createmgtTable();
        createAttendence();
        createStaff();
        createPatient();
        createEmPatient();
        createScheduleTable();

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
      try{  //String sql= "drop table userTable";
                String sql= "create table userTable("+ 
                  "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                  "userId varchar(30) UNIQUE, "+
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
void createmgtTable(){
      try{ // String sql= "drop table mgtTable";
                String sql= "create table mgtTable("+ 
                  "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                  "name varchar(30) NOT NULL, "+
                  "post varchar(22) NOT NULL, "+
                  "position varchar(22) NOT NULL, "+
                  "bioimg blob,"+
                  "date TIMESTAMP NOT NULL DEFAULT current_timestamp)";
          stmt.executeUpdate(sql);
          System.out.println("Management Table created");
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
  }
void createStaffTable(){
      try{  //String sql= "drop table staffTable";
                String sql= "create table staffTable("+ 
                  "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                  "userId varchar(30) UNIQUE, "+
                  "name varchar(30) NOT NULL, "+
                  "password varchar(20) NOT NULL, "+  
		  "phone varchar(25) NOT NULL, "+ 
		  "email varchar(50) NOT NULL, "+  
		  "dob varchar(30) NOT NULL, "+  
		  "mstatus varchar(30) NOT NULL, "+
		  "gender varchar(30) NOT NULL, "+
		  "address varchar(500) NOT NULL, "+ 
		  "department varchar(30) NOT NULL, "+ 
		  "qualification varchar(100) NOT NULL, "+
		  "sepcialization varchar(30) NOT NULL, "+
		  "doe varchar(30) NOT NULL, "+
		  "post varchar(50) NOT NULL, "+  
		  "stafftype varchar(30) NOT NULL, "+  
		  "status varchar(30) NOT NULL, "+  
                  "staffimg blob,"+
                  "date TIMESTAMP NOT NULL DEFAULT current_timestamp)";
          stmt.executeUpdate(sql);
          System.out.println("Staff Table created");
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
  }
   void createNotice(){
   try{  
//String sql= "drop table  notice";
     String sql = "create table notice( "+
                        "serail integer PRIMARY KEY AUTOINCREMENT, "+
                        "notice_id varchar(11),"+
                        "title varchar(90), "+
			"content varchar(2000), "+
                        "time TIMESTAMP NOT NULL DEFAULT current_timestamp)";
     
      			stmt.executeUpdate(sql);
            System.out.println("Notice Table created");
                    }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
     void createAttendence(){
   try{  
//String sql= "drop table  attendence";
//                    stmt.executeUpdate(sql);
//                    System.out.println("table created Droped");
     String sql = "create table attendence( "+
                        "serail integer PRIMARY KEY AUTOINCREMENT, "+
                        "staff_id varchar(11),"+
                        "name varchar(30), "+
                        "department varchar(22), "+
                        "departure TIMESTAMP DEFAULT '', "+
                        "arrival TIMESTAMP NOT NULL DEFAULT current_timestamp)";
     
      			stmt.executeUpdate(sql);
            System.out.println("AttendenceTable created");
                    }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
 void createStaff(){
    try{  
//String sql= "drop table  staff";
//                    stmt.executeUpdate(sql);
//                    System.out.println("table created Droped");
     String sql = "create table staff( "+
                        "staff_id varchar(11) primary key,"+
                        "name varchar(30), "+
                        "department varchar(22), "+
                        "finimg longblob,"+
			 "gencode varchar(30), "+
                        "date TIMESTAMP NOT NULL DEFAULT current_timestamp)";
     
      			stmt.executeUpdate(sql);
            System.out.println("Staff Table created");
                    }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
void createPatient(){
        try{ //String sql= "drop table  patient";
            String sql = "create table patient( "+
			 "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                         "paitentID varchar(20) UNIQUE,"+
                         "Pname varchar(30), "+
                         "mobileP varchar(22), "+
                         "emailp varchar(22), "+
			 "dobP varchar(22), "+
                         "addressCP varchar(500), "+
                         "paitentDpt varchar(50),"+
			 "rankP varchar(22),"+
			 "paitentPOB varchar(30), "+
			 "paitentVillage varchar(30), "+
			 "genderP varchar(10), "+
			 "genderKP varchar(30), "+
                         "paitentTown varchar(20), "+
			 "paitentSO varchar(22), "+
			 "paitentLGA varchar(30), "+
			 "paitentCityofR varchar(20), "+
			 "paitentSchoolAddress varchar(500), "+
			 "paitentGenotype varchar(5), "+
			 "PKname varchar(30), "+
			 "paitentkMobile varchar(20), "+
			 "paitentkEmail varchar(50), "+
			 "paitentkRelationship varchar(20), "+
			 "pimg blob,"+
                         "paitentAllegy varchar(22), "+
                         "paitentDisbility varchar(100), "+
                         "status varchar(15), "+
                         "paitentBloodgrp varchar(5), "+
                         "paitentType varchar(15), "+
                  	 "date TIMESTAMP NOT NULL DEFAULT current_timestamp)";                
                     
            stmt.executeUpdate(sql);
            System.out.println("Patient Table created");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
        }
    } 
 void createEmPatient(){
        try{ //String sql= "drop table  emergencyPatient";
            String sql = "create table emergencyPatient( "+
                         "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                         "epatientIDcard varchar(20) UNIQUE,"+
                         "epname varchar(22), "+
                         "epgender varchar(22), "+
                         "epmobile varchar(22), "+
			 "epaddress varchar(250), "+
                         "epstatus varchar(9), "+
                         "epdob varchar(11),"+
			 "epkinname varchar(22),"+
			 "epkmobile varchar(22), "+
			 "epkemail varchar(22), "+
                         "epkgender varchar(6), "+
			 "epkrelationship varchar(22), "+
			 "epkaddress varchar(250),"+
                         "date TIMESTAMP NOT NULL DEFAULT current_timestamp)";                
                                        
                     
            stmt.executeUpdate(sql);
            System.out.println("Emergency Patient Table created");
        }
        catch(Exception e){
           System.out.println(e.getMessage());
        }
    }
 void createScheduleTable(){
      try{ // String sql= "drop table schedule";
                String sql= "create table schedule("+ 
                  "ssn integer PRIMARY KEY AUTOINCREMENT, "+
                  "userId varchar(30), "+
		  "name varchar(30) NOT NULL, "+
                  "day varchar(15) NOT NULL, "+
                  "dutydate DATE NOT NULL, "+
                  "startTime TIME NOT NULL, "+
                  "endTime TIME NOT NULL, "+
		  "post varchar(50) NOT NULL, "+ 
		"date TIMESTAMP NOT NULL DEFAULT current_timestamp)";
      
		
		stmt.executeUpdate(sql);
          System.out.println("Schedule Table created");
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
      }
  }
 
    public boolean executeAction(String sql){
      try{
          stmt.execute(sql);
                return true;
      }
      catch(SQLException e){
          System.out.println(e.getMessage());
          return false;
      }
  }    
      public boolean executeAction(PreparedStatement preparedStatement) {
        try {
            boolean r = preparedStatement.execute();
            System.out.println("value from prepared " + r);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
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
      public PreparedStatement createPreparedStatements(String sql) {

        try {
            return conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(StaffRecordUIController.StaffTable staffTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
