/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.kca.week5;


import java.sql.Connection; 

import java.sql.DriverManager; 

import java.sql.SQLException; 

 

public class Week5 { 

    public static void main(String[] args) { 

        // Database URL and credentials 

        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Replace 'mydatabase' with your database name 

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
