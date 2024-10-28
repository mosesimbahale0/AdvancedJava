package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        // Validate input
//        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
//            try (PrintWriter out = response.getWriter()) {
//                out.println("<html><body>");
//                out.println("<p style='color:red;'>Username and password cannot be empty.</p>");
//                out.println("</body></html>");
//            }
//            return;
//        }
//
//        // Check credentials in database
//        try (Connection connection = DatabaseConnector.getConnection()) {
//            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, username);
//                statement.setString(2, hashPassword(password));
//                ResultSet resultSet = statement.executeQuery();
//
//                try (PrintWriter out = response.getWriter()) {
//                    out.println("<html><body>");
//                    if (resultSet.next()) {
//                        // User exists, login successful
//                        HttpSession session = request.getSession();
//                        session.setAttribute("username", username);
//                        out.println("<p style='color:green;'>Login successful! Welcome, " + username + ".</p>");
//                    } else {
//                        // Invalid credentials
//                        out.println("<p style='color:red;'>Invalid username or password.</p>");
//                    }
//                    out.println("</body></html>");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().println("<p style='color:red;'>Database Error: " + e.getMessage() + "</p>");
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.getWriter().println("<p style='color:red;'>Unexpected Error: " + e.getMessage() + "</p>");
//        }
//    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");

        // Validate input
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<p style='color:red;'>Username and password cannot be empty.</p>");
                out.println("</body></html>");
            }
            return;
        }

        // Check credentials in the database
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, hashPassword(password)); // Use hashed password if applicable
                ResultSet resultSet = statement.executeQuery();

                try (PrintWriter out = response.getWriter()) {
                    out.println("<html><body>");
                    if (resultSet.next()) {
                        // User exists, login successful
                        HttpSession session = request.getSession();
                        session.setAttribute("isAuthenticated", true);
                        session.setAttribute("username", username); // Optional, store username in session
                        out.println("<p style='color:green;'>Login successful! Welcome, " + username + ".</p>");
                        out.println("<a href='view-books'>Go to View Books</a>"); // Link to protected page
                    } else {
                        // Invalid credentials
                        out.println("<p style='color:red;'>Invalid username or password.</p>");
                        out.println("<a href='login'>Try again</a>");
                    }
                    out.println("</body></html>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("<p style='color:red;'>Database Error: " + e.getMessage() + "</p>");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("<p style='color:red;'>Unexpected Error: " + e.getMessage() + "</p>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Login</h1>");
            out.println("<form method='POST' action='/web-app/login'>");
            out.println("<label for='username'>Username:</label><br>");
            out.println("<input type='text' id='username' name='username' required><br><br>");
            out.println("<label for='password'>Password:</label><br>");
            out.println("<input type='password' id='password' name='password' required><br><br>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
            out.println("</body></html>");
        }
    }

//    private String hashPassword(String password) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = digest.digest(password.getBytes());
//            return Base64.getEncoder().encodeToString(hashedBytes);
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Failed to hash password", e);
//        }
//    }
    @Override
    public String getServletInfo() {
        return "Servlet that handles user login.";
    }
}
