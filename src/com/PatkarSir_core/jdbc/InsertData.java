package com.PatkarSir_core.jdbc;

import java.sql.*;

public class InsertData {


    private static final String URL = "jdbc:mysql://localhost:3306/whatsapp";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "11091995";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Welcome to JDBC");

        System.out.println("STEP 1. LOADING DRIVER . . .");
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("DRIVER LOADED . . . ");

        System.out.println("STEP 2. ESTABLISHING CONNECTION . . .");
        Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        System.out.println("CONNECTION ESTABLISHED . . ");

        System.out.println("STEP 3. Createing Statment object from connection object . . .");
        Statement statement = conn.createStatement();
        System.out.println("STATMENT CREATED . . ");

        System.out.println("STEP 4. EXECUTING THE QUERY and obtaining resultset . . .");
        boolean isInserted = statement.execute("INSERT INTO USER VALUES(4,'SWETA','123456','sat@gmail.com','123456789');");
        //error
        if(isInserted){
            System.out.println("INSERT SUCCESFUL");
        }else{
            System.out.println("INSERT FAILED");
        }
    }
}
