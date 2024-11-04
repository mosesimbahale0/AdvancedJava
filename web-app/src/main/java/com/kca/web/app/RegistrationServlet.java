package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Base64;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/register"})
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        response.setContentType("text/html;charset=UTF-8");

        if (username == null || password == null || confirmPassword == null
                || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            sendErrorMessage(response, "All fields are required.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            sendErrorMessage(response, "Passwords do not match.");
            return;
        }

        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, hashPassword(password));
                int result = statement.executeUpdate();

                try (PrintWriter out = response.getWriter()) {
                    out.println("<html><body>");
                    if (result > 0) {
                        out.println("<p class='success'>Registration successful!</p>");
                        out.println("<a href='/web-app/login'>Login</a> | <a href='/web-app/view-books'>Books</a>");
                    } else {
                        out.println("<p class='error'>Registration failed. Please try again.</p>");
                        out.println("<a href='/web-app/register'>Register</a> | <a href='/web-app/login'>Login</a>");
                    }
                    out.println("</body></html>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            sendErrorMessage(response, "Database Error: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            sendErrorMessage(response, "Unexpected Error: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    private void sendErrorMessage(HttpServletResponse response, String message) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<p class='error'>" + message + "</p>");
            out.println("</body></html>");
        }
    }

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
    public String getServletInfo() {
        return "Servlet that handles user registration.";
    }
}
