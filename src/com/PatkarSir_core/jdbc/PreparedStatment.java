package com.PatkarSir_core.jdbc;

import java.sql.*;

public class PreparedStatment {


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
        String str = "INSERT INTO USER VALUES(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(str);
        ps.setInt(1,5);
        ps.setString(2,"SWETA");
        ps.setString(3,"123456");
        ps.setString(4,"sat@gmail.com");
        ps.setString(5,"123456");
        System.out.println("STATMENT CREATED . . ");

        boolean isInserted = ps.execute();
        //error
        if(isInserted){
            System.out.println("INSERT SUCCESFUL");
        }else{
            System.out.println("INSERT FAILED");
        }
    }
}
