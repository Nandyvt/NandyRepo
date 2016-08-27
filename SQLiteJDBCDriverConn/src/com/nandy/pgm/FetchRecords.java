package com.nandy.pgm;

//STEP 1. Import required packages
import java.sql.*;

public class FetchRecords {
 // JDBC driver name and database URL
 static final String JDBC_DRIVER = "org.sqlite.JDBC";  
 static final String DB_URL = "jdbc:sqlite:C:/db_files/files/MyDb.sqlite";

 //  Database credentials
/* static final String USER = "username";
 static final String PASS = "password";*/
 
 public static void main(String[] args) {
 Connection conn = null;
 Statement stmt = null;
 try{
    //STEP 2: Register JDBC driver
    Class.forName(JDBC_DRIVER);

    //STEP 3: Open a connection
    System.out.println("Connecting to a selected database...");
    conn = DriverManager.getConnection(DB_URL);
    System.out.println("Connected database successfully...");
    
    //STEP 4: Execute a query
    System.out.println("Creating statement...");
    stmt = conn.createStatement();

    String sql = "select Name,mobileNum,designation,Role,Location,Empid from Employee;";
    ResultSet rs = stmt.executeQuery(sql);
    //STEP 5: Extract data from result set
    while(rs.next()){
       //Retrieve by column name
    	String Name = rs.getString("Name");
    	long mobNum=rs.getLong("mobileNum");
    	String designation = rs.getString("designation");
    	String Role = rs.getString("Role");
    	String Loc = rs.getString("Location");
    	long Empid=rs.getLong("EmpId");
   

       //Display values
       System.out.print("Name: " + Name);
       System.out.print(", mobNum: " + mobNum);
       System.out.print(", designation: " + designation);
       System.out.println(", Role: " + Role);
       System.out.println(", Loc: " + Role);
       System.out.println(", Empid: " + Empid);
    }
    rs.close();
 }catch(SQLException se){
    //Handle errors for JDBC
    se.printStackTrace();
 }catch(Exception e){
    //Handle errors for Class.forName
    e.printStackTrace();
 }finally{
    //finally block used to close resources
    try{
       if(stmt!=null)
          conn.close();
    }catch(SQLException se){
    }// do nothing
    try{
       if(conn!=null)
          conn.close();
    }catch(SQLException se){
       se.printStackTrace();
    }//end finally try
 }//end try
 System.out.println("Goodbye!");
}//end main
}//end JDBCExample
