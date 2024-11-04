package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewBookServlet", urlPatterns = {"/view-books", "/test-db"})
public class ViewBookServlet extends HttpServlet {

    // Check if the user is authenticated
    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Don't create a new session if it doesn't exist
        return (session != null && session.getAttribute("username") != null);
    }

    // Retrieve books from the database
    private List<Book> getBooksFromDatabase() {
        List<Book> books = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection()) {
            String sql = "SELECT title, author, description, created_at, img, rating, price, stock FROM books;";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String description = resultSet.getString("description");
                    String createdAt = resultSet.getString("created_at");
                    String img = resultSet.getString("img");
                    double rating = resultSet.getDouble("rating");
                    double price = resultSet.getDouble("price");
                    int stock = resultSet.getInt("stock");

                    books.add(new Book(title, author, description, createdAt, img, rating, price, stock));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error retrieving books: " + e.getMessage());
        }
        return books;
    }

    // Test the database connection
    private boolean testDatabaseConnection() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            return connection != null;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error during database connection test: " + e.getMessage());
        }
        return false;
    }

    // Handle database connection test requests
    protected void testDbRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect("login"); // Redirect to login page if not authenticated
            return;
        }

        boolean dbConnection = testDatabaseConnection();
        request.setAttribute("dbConnection", dbConnection);
        request.getRequestDispatcher("/dbTest.jsp").forward(request, response);
    }

    // Handle book viewing requests
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect("login"); // Redirect to login page if not authenticated
            return;
        }

        List<Book> books = getBooksFromDatabase();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/allBooks.jsp").forward(request, response);
    }

    // Handle logout
    protected void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false); // Get existing session
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        response.sendRedirect("login"); // Redirect to login page
    }

    // Override the doGet method to handle requests based on URL paths
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/test-db".equals(path)) {
            testDbRequest(request, response);
        } else if ("/logout".equals(path)) {
            handleLogout(request, response);
        } else {
            processRequest(request, response);
        }
    }

    // Override the doPost method to handle post requests for adding books to cart
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet that displays books from the database or tests the database connection.";
    }
}
