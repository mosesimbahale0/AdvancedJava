package com.kca.cattwo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        if (username == null || username.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Username cannot be empty.");
            request.getRequestDispatcher("/loginError.jsp").forward(request, response);
            return;
        }

        // Create a session and add user details
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("isAuthenticated", true);

        // Redirect to dashboard
        response.sendRedirect("dashboard");
    }
}
