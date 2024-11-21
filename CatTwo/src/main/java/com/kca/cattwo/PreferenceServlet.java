package com.kca.cattwo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PreferencesServlet", urlPatterns = {"/preferences"})
public class PreferenceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Retrieve user preferences from session
        String preferences = (String) session.getAttribute("preferences");
        if (preferences == null) {
            preferences = "Default Preferences";
            session.setAttribute("preferences", preferences); // Initialize preferences
        }

        request.setAttribute("preferences", preferences);
        request.getRequestDispatcher("/preferences.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        // Update preferences in session
        String newPreferences = request.getParameter("preferences");
        session.setAttribute("preferences", newPreferences);

        response.sendRedirect("preferences");
    }

    @Override
    public String getServletInfo() {
        return "Servlet for managing user preferences.";
    }
}
