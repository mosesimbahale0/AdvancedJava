package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewBookServlet", urlPatterns = {"/view-books", "/test-db"})
public class ViewBookServlet extends HttpServlet {

    // Method to check if the user is authenticated
    private boolean isAuthenticated(HttpServletRequest request) {
        HttpSession session = request.getSession(false); // Do not create a session if one does not exist
        return (session != null && session.getAttribute("username") != null);
    }

    // Method to retrieve books from the database
    private List<Book> getBooksFromDatabase() {
        List<Book> books = new ArrayList<>();
        System.out.println("Attempting to connect to the database...");

        try (Connection connection = DatabaseConnector.getConnection()) {
            System.out.println("Database connection successful.");
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

                System.out.println("Query executed successfully. Books retrieved: " + books.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error retrieving books: " + e.getMessage());
        }

        return books;
    }

    // Method to test the database connection
    private boolean testDatabaseConnection() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            if (connection != null) {
                System.out.println("Database connection successful!");
                return true;
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error during database connection test: " + e.getMessage());
        }

        return false;
    }

    // Method for handling requests to test the database connection via /test-db
    protected void testDbRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect("login"); // Redirect to login page if not authenticated
            return;
        }

        response.setContentType("text/html;charset=UTF-8");
        boolean dbConnection = testDatabaseConnection();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Database Test</title>");
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

    // Method to handle requests for viewing books
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        if (!isAuthenticated(request)) {
//            response.sendRedirect("login"); // Redirect to login page if not authenticated
//            return;
//        }
//
//        response.setContentType("text/html;charset=UTF-8");
//        List<Book> books = getBooksFromDatabase();
//
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>All Books</title>");
//            out.println("<style>");
//            out.println("button { background-color: #ff5733; color: white; border: none; padding: 10px 20px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; border-radius: 5px; }");
//            out.println("</style>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>All Books in the Database</h1>");
//
//            // Logout button
//            out.println("<form action='logout' method='GET'>");
//            out.println("<button type='submit'>Logout</button>");
//            out.println("</form>");
//
//            out.println("<ul>");
//
//            for (Book book : books) {
//                out.println("<li><strong>Title:</strong> " + book.getTitle() + "<br>");
//                out.println("<strong>Author:</strong> " + book.getAuthor() + "<br>");
//                out.println("<strong>Description:</strong> " + book.getDescription() + "<br>");
//                out.println("<strong>Published Date:</strong> " + book.getCreatedAt() + "<br>");
//                out.println("<strong>Price:</strong> $" + book.getPrice() + "<br>");
//                out.println("<strong>Rating:</strong> " + book.getRating() + " / 5.0<br>");
//                out.println("<strong>Stock:</strong> " + book.getStock() + "<br>");
//                out.println("<img src=\"" + book.getImg() + "\" alt=\"Book cover\" style=\"width:100px;height:auto;\"><br><br>");
//                out.println("</li>");
//            }
//
//            out.println("</ul>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    // Method to handle requests for viewing books
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!isAuthenticated(request)) {
            response.sendRedirect("login"); // Redirect to login page if not authenticated
            return;
        }

        response.setContentType("text/html;charset=UTF-8");
        List<Book> books = getBooksFromDatabase();

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>All Books</title>");
            out.println("<style>");
            out.println("button { background-color: #ff5733; color: white; border: none; padding: 10px 20px; text-align: center; text-decoration: none; display: inline-block; font-size: 16px; margin: 4px 2px; cursor: pointer; border-radius: 5px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>All Books in the Database</h1>");

            // Logout button
            out.println("<form action='logout' method='GET'>");
            out.println("<button type='submit'>Logout</button>");
            out.println("</form>");

            out.println("<ul>");

            for (Book book : books) {
                out.println("<li><strong>Title:</strong> " + book.getTitle() + "<br>");
                out.println("<strong>Author:</strong> " + book.getAuthor() + "<br>");
                out.println("<strong>Description:</strong> " + book.getDescription() + "<br>");
                out.println("<strong>Published Date:</strong> " + book.getCreatedAt() + "<br>");
                out.println("<strong>Price:</strong> $" + book.getPrice() + "<br>");
                out.println("<strong>Rating:</strong> " + book.getRating() + " / 5.0<br>");
                out.println("<strong>Stock:</strong> " + book.getStock() + "<br>");
                out.println("<img src=\"" + book.getImg() + "\" alt=\"Book cover\" style=\"width:100px;height:auto;\"><br><br>");

                // Add to Cart button
                out.println("<form action='cart' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='title' value='" + book.getTitle() + "'/>");
                out.println("<input type='number' name='quantity' value='1' min='1' style='width: 50px;'/>");
                out.println("<input type='hidden' name='action' value='add'/>");
                out.println("<button type='submit'>Add to Cart</button>");
                out.println("</form>");

                out.println("</li>");
            }

            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Method to handle logout
    protected void handleLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false); // Get existing session
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }
        response.sendRedirect("login"); // Redirect to login page
    }

    // Override the doGet method to handle different requests based on the URL path
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if ("/test-db".equals(path)) {
            testDbRequest(request, response);
        } else if ("/logout".equals(path)) {
            handleLogout(request, response); // Handle logout request
        } else {
            processRequest(request, response);
        }
    }

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
