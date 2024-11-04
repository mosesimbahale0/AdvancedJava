package com.kca.sessiontrackingexample;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SetCookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Create a cookie
            Cookie userCookie = new Cookie("username", "MoseImbahale");
        
        // Set the cookie's max age to 1 day (86400 seconds)
        userCookie.setMaxAge(86400);
        
        // Add the cookie to the response
        response.addCookie(userCookie);
        
        // Set response content type and encoding
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        // Output response
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head><title>Cookie Set</title></head>");
            out.println("<body>");
            out.println("<h1>Cookie for username set.</h1>");
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
//@WebServlet("/setcookie")
//public class SetCookieServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Create a new cookie
//        Cookie userCookie = new Cookie("username", "JohnDoe");
//
//        // Set the cookie's max age to 1 day (86400 seconds)
//        userCookie.setMaxAge(86400);
//
//        // Add the cookie to the response
//        response.addCookie(userCookie);
//
//        // Set the response content type and character encoding
//        response.setContentType("text/html");
//        response.setCharacterEncoding("UTF-8");
//
//        // Get the PrintWriter to write the response
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<html>");
//            out.println("<head><title>Cookie Set</title></head>");
//            out.println("<body>");
//            out.println("<h1>Cookie for username set.</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//}
