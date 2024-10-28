package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    // Method to process requests
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        // Get cart from session or create a new one
        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String title = request.getParameter("title");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            CartItem item = cart.get(title);
            if (item == null) {
                cart.put(title, new CartItem(title, quantity));
            } else {
                item.setQuantity(item.getQuantity() + quantity);
            }
        } else if ("remove".equals(action)) {
            String title = request.getParameter("title");
            cart.remove(title);
        }

        // Display the cart items
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Your Cart</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Your Shopping Cart</h1>");
            out.println("<ul>");
            for (CartItem item : cart.values()) {
                out.println("<li>" + item.getTitle() + " - Quantity: " + item.getQuantity()
                        + " <a href='cart?action=remove&title=" + item.getTitle() + "'>Remove</a></li>");
            }
            out.println("</ul>");
            out.println("<h3>Add Item</h3>");
            out.println("<form action='cart' method='post'>");
            out.println("Title: <input type='text' name='title' required><br>");
            out.println("Quantity: <input type='number' name='quantity' required><br>");
            out.println("<input type='hidden' name='action' value='add'>");
            out.println("<input type='submit' value='Add to Cart'>");
            out.println("</form>");
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
        return "Cart Servlet that allows users to add/remove items and view their cart.";
    }
}

///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package com.kca.web.app;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
///**
// *
// * @author moses-imbahale
// */
//public class CartServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CartServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CartServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
