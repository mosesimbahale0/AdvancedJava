/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kca.web.app;

/**
 *
 * @author moses-imbahale
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnector {

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Adjust driver class as needed
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/advanced_java_db", "root", "password");
    }
}
