package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LogoutServlet", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    // Method to process requests for both HTTP GET and POST methods
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Invalidate the current session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // Invalidate the session
        }

        // Set response content type
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Output logout confirmation page
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Logout Successful</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Logout Successful</h1>");
            out.println("<p>You have been logged out successfully.</p>");
            out.println("<a href='login'>Click here to login again</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Handle the HTTP GET method
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Handle the HTTP POST method
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Return a short description of the servlet
    @Override
    public String getServletInfo() {
        return "Logout Servlet that invalidates the user session and redirects to the login page.";
    }
}
