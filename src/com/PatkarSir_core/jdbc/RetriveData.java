package com.PatkarSir_core.jdbc;

import java.sql.*;

public class RetriveData {

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
        ResultSet rs = statement.executeQuery("Select * from USER");
        System.out.println("RESULTSET OBTAINED");


        System.out.println("UID  |  NAME  |  PASSWORD  |  EMAIL  |  PHONENUMBER  ");
        while(rs.next()){
            int uid = rs.getInt("UID");
            String name = rs.getString("NAME");
            String password = rs.getString("PASSWORD");
            String email = rs.getString("EMAIL");
            String phoneNumber = rs.getString("PHONENUMBER");
            System.out.println(""+uid+" | "+name+" | "+ password+ " | "+email+" | "+phoneNumber);
        }

    }
}
