package com.kca.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Example1 {

    public static void main(String[] args) {

        // Database URL and credentials 
        String url = "jdbc:mysql://localhost:3306/week5";
        String username = "root";
        String password = "password";

        try {

            // Establish connection 
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to the database successfully!");

//            String query = "SELECT * FROM books"; // Replace 'books' with your table name
//            ResultSet resultSet = statement.executeQuery(query);
//
//            while (resultSet.next()) {
//                System.out.println("Book ID: " + resultSet.getInt("id"));
//                System.out.println("Title: " + resultSet.getString("title"));
//                System.out.println("Author: " + resultSet.getString("author"));
//                System.out.println("--------------------");
//            }
//            resultSet.close();
//            statement.close();

            // Close the connection 
            connection.close();

        } catch (SQLException e) {

            System.out.println("Connection failed: " + e.getMessage());

        }

    }

}
