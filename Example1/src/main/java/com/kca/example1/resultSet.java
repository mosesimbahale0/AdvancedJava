package com.kca.example1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class resultSet {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/week5"; // Replace with your DB name
        String username = "root"; // Replace with your username
        String password = "password"; // Replace with your password

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {

            // Execute a SELECT query
            String query = "SELECT id, title, author FROM books"; // Replace 'books' with your table name
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the ResultSet and print data
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");

                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("-----------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
