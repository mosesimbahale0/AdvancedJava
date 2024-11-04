package com.kca.urlrewritingexample;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class RetrieveSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve the session, do not create a new one if it doesn't exist
        HttpSession session = request.getSession(false);
        String username = null;

        // Check if session exists and get the "username" attribute
        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        // Set the response content type and display the username
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Write HTML content to the response
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Retrieve Session</title></head>");
        response.getWriter().println("<body>");
        if (username != null) {
            response.getWriter().println("<h1>Welcome back, " + username + "!</h1>");
        } else {
            response.getWriter().println("<h1>No active session found.</h1>");
        }
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
