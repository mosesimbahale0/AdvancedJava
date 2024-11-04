package com.kca.urlrewritingexample;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class StartSessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a new session or retrieve an existing one
        HttpSession session = request.getSession();

        // Set an attribute "username" with a sample value
        session.setAttribute("username", "JaneDoe");

        // Send a response with a link to the next servlet, using URL rewriting
        String url = response.encodeURL("retrievesession");
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Write HTML content to the response
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Session Started</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h1>Session started.</h1>");
        response.getWriter().println("<p><a href='" + url + "'>Go to Retrieve Session</a></p>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}
