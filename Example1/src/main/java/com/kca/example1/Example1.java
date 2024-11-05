package com.kca.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example1 {

    public static void main(String[] args) {

        // Database URL and credentials 
        String url = "jdbc:mysql://localhost:3306/week5"; // Replace 'mydatabase' with your database name 

        String username = "root"; // Replace with your database username 

        String password = "password"; // Replace with your database password 

        try {

            // Establish connection 
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database successfully!");

            // Close the connection 
            connection.close();

        } catch (SQLException e) {

            System.out.println("Connection failed: " + e.getMessage());

        }

    }

}
