/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kca.storedprocedures;

import java.sql.*;

public class BookDatabaseManager {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Library";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    // Main method to demonstrate operations
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            System.out.println("Connected to the database.");

            // Insert a new book
            insertBook(connection, "The Catcher in the Rye", "J.D. Salinger");
            insertBook(connection, "To Kill a Mockingbird", "Harper Lee");

            // Update an existing book
            updateBook(connection, 1, "The Great Gatsby", "F. Scott Fitzgerald");

            // Retrieve all books
            retrieveBooks(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Insert a book into the database
    private static void insertBook(Connection connection, String title, String author) {
        String insertQuery = "INSERT INTO Books (Title, Author) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println(rowsInserted + " book(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update a book's details by BookID
    private static void updateBook(Connection connection, int bookID, String newTitle, String newAuthor) {
        String updateQuery = "UPDATE Books SET Title = ?, Author = ? WHERE BookID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newTitle);
            preparedStatement.setString(2, newAuthor);
            preparedStatement.setInt(3, bookID);
            int rowsUpdated = preparedStatement.executeUpdate();
            System.out.println(rowsUpdated + " book(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve and display all books from the database
    private static void retrieveBooks(Connection connection) {
        String selectQuery = "SELECT * FROM Books";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery); ResultSet resultSet = preparedStatement.executeQuery()) {
            System.out.println("Books in the database:");
            while (resultSet.next()) {
                int bookID = resultSet.getInt("BookID");
                String title = resultSet.getString("Title");
                String author = resultSet.getString("Author");
                System.out.println(bookID + ": " + title + " by " + author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
