package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate input
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Username and password cannot be empty.");
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
            return;
        }

        // Check credentials in the database
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, hashPassword(password)); // Use hashed password if applicable
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // User exists, login successful
                    HttpSession session = request.getSession();
                    session.setAttribute("isAuthenticated", true);
                    session.setAttribute("username", username);
                    response.sendRedirect("/web-app/view-books"); // Redirect to /view-books on successful login
                } else {
                    // Invalid credentials
                    request.setAttribute("errorMessage", "Invalid username or password.");
                    request.getRequestDispatcher("/loginError.jsp").forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Database Error: " + e.getMessage());
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Unexpected Error: " + e.getMessage());
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
        }
    }

    // Password hashing method
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Failed to hash password", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/loginForm.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that handles user login.";
    }
}
