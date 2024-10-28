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

        // Basic validation
        if (username == null || password == null || confirmPassword == null
                || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<p style='color:red;'>All fields are required.</p>");
                out.println("</body></html>");
            }
            return;
        }

        // Password match validation
        if (!password.equals(confirmPassword)) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<p style='color:red;'>Passwords do not match.</p>");
                out.println("</body></html>");
            }
            return;
        }

        // Insert the new user into the database
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, username);
                statement.setString(2, hashPassword(password));
                int result = statement.executeUpdate();

                try (PrintWriter out = response.getWriter()) {
                    out.println("<html><body>");
                    if (result > 0) {
                        out.println("<p style='color:green;'>Registration successful!</p>   <br/>  <a href=\"/web-app/login\">Login</a>              <a href=\"/web-app/view-books\">Books</a>");
                    } else {
                        out.println("<p style='color:red;'>Registration failed. Try again.</p>           <a href=\"/web-app/register\">Register</a>\n"
                                + "        <br/>\n"
                                + "        <a href=\"/web-app/login\">Login</a>\n"
                                + "          <br/>\n"
                                + "          <a href=\"/web-app/view-books\">Books</a>\n"
                                + "          <br/>");
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Register</h1>");
            out.println("<form method='POST' action='/web-app/register'>");
            out.println("<label for='username'>Username:</label><br>");
            out.println("<input type='text' id='username' name='username' required><br><br>");
            out.println("<label for='password'>Password:</label><br>");
            out.println("<input type='password' id='password' name='password' required><br><br>");
            out.println("<label for='confirmPassword'>Confirm Password:</label><br>");
            out.println("<input type='password' id='confirmPassword' name='confirmPassword' required><br><br>");
            out.println("<input type='submit' value='Register'>");
            out.println("</form>");
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

//package com.kca.web.app;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Base64;
//
//@WebServlet(name = "RegistrationServlet", urlPatterns = {"/register"})
//public class RegistrationServlet extends HttpServlet {
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//
//        response.setContentType("text/html;charset=UTF-8");
//
//        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
//            try (PrintWriter out = response.getWriter()) {
//                out.println("<html><body>");
//                out.println("<p style='color:red;'>Username and password cannot be empty.</p>");
//                out.println("</body></html>");
//            }
//            return;
//        }
//
//        // Insert the new user into the database
//        try (Connection connection = DatabaseConnector.getConnection()) {
//            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                statement.setString(1, username);
//                statement.setString(2, hashPassword(password));
//                int result = statement.executeUpdate();
//
//                try (PrintWriter out = response.getWriter()) {
//                    out.println("<html><body>");
//                    if (result > 0) {
//                        out.println("<p style='color:green;'>Registration successful!</p>");
//                    } else {
//                        out.println("<p style='color:red;'>Registration failed. Try again.</p>");
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
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html><body>");
//            out.println("<h1>Register</h1>");
//            out.println("<form method='POST' action='/web-app/register'>");
//            out.println("<label for='username'>Username:</label><br>");
//            out.println("<input type='text' id='username' name='username'><br><br>");
//            out.println("<label for='password'>Password:</label><br>");
//            out.println("<input type='password' id='password' name='password'><br><br>");
//            out.println("<input type='submit' value='Register'>");
//            out.println("</form>");
//            out.println("</body></html>");
//        }
//    }
//
//    private String hashPassword(String password) {
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hashedBytes = digest.digest(password.getBytes());
//            return Base64.getEncoder().encodeToString(hashedBytes);
//        } catch (NoSuchAlgorithmException e) {
//            // Log error and throw runtime exception to halt registration process
//            throw new RuntimeException("Failed to hash password", e);
//        }
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Servlet that handles user registration.";
//    }
//}
