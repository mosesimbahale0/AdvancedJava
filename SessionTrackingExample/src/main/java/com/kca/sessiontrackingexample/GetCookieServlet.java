package com.kca.sessiontrackingexample;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve all cookies
        Cookie[] cookies = request.getCookies();
        String username = "Unknown";

        // Find the cookie named "username"
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }

        // Set response content type and encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Output response
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Get Cookie</title></head>");
            out.println("<body>");
            out.println("<h1>Welcome, " + username + "!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}

//package com.kca.sessiontrackingexample;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@WebServlet("/getcookie")
//public class GetCookieServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Get all cookies from the request 
//        Cookie[] cookies = request.getCookies();
//        String username = null;
//
//        // Check if cookies are not null 
//        if (cookies != null) {
//            // Loop through each cookie to find the one with the name 'username' 
//            for (Cookie cookie : cookies) {
//                if (cookie.getName().equals("username")) {
//                    username = cookie.getValue();
//                    break;
//                }
//            }
//        }
//
//        // Set the response content type and character encoding
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//
//        // Get the PrintWriter to write the response
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html>");
//            out.println("<head><title>Cookie Retrieved</title></head>");
//            out.println("<body>");
//            if (username != null) {
//                out.println("<h1>Hello, " + username + "!</h1>");
//            } else {
//                out.println("<h1>No user found.</h1>");
//            }
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//}
