package com.kca.cattwo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DashboardServlet", urlPatterns = {"/dashboard"})
public class DashboardsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve session and user data
        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("isAuthenticated"))) {
            String username = (String) session.getAttribute("username");
            String role = (String) session.getAttribute("role");

            // Display dashboard content
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Welcome to the Dashboard</h1>");
            response.getWriter().println("<p>Username: " + username + "</p>");
            response.getWriter().println("<p>Role: " + role + "</p>");
            response.getWriter().println("</body></html>");
        } else {
            // If not authenticated, redirect to login page
            response.sendRedirect("loginForm.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet that handles dashboard display.";
    }
}
