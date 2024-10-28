package com.kca.web.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DatabaseTestServlet", urlPatterns = {"/test-db"})
public class DatabaseTestServlet extends HttpServlet {

    // Method to test database connection
    private boolean testDatabaseConnection() {
        try (Connection connection = DatabaseConnector.getConnection()) { // Use DatabaseConnector
            return connection != null; // Return true if connection is successful
        } catch (Exception e) {
            e.printStackTrace(); // Log error details to console
            System.out.println("Error details: " + e.getMessage());
            return false; // Return false if connection fails
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean dbConnection = testDatabaseConnection(); // Test the database connection

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Database Connection Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Database Connection Test</h1>");
            if (dbConnection) {
                out.println("<p style='color:green;'>Connection successful!</p>");
            } else {
                out.println("<p style='color:red;'>Connection failed!</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet for testing database connection.";
    }
}
