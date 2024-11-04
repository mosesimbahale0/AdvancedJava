package com.kca.web.app;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        // Forward to JSP
        request.getRequestDispatcher("/cart.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

//package com.kca.web.app;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
//public class CartServlet extends HttpServlet {
//
//    // Method to process requests
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        HttpSession session = request.getSession();
//
//        // Get cart from session or create a new one
//        Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new HashMap<>();
//            session.setAttribute("cart", cart);
//        }
//
//        String action = request.getParameter("action");
//
//        if ("add".equals(action)) {
//            String title = request.getParameter("title");
//            int quantity = Integer.parseInt(request.getParameter("quantity"));
//            CartItem item = cart.get(title);
//            if (item == null) {
//                cart.put(title, new CartItem(title, quantity));
//            } else {
//                item.setQuantity(item.getQuantity() + quantity);
//            }
//        } else if ("remove".equals(action)) {
//            String title = request.getParameter("title");
//            cart.remove(title);
//        }
//
//        // Display the cart items
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Your Cart</title>");
//            out.println("<link href='https://fonts.googleapis.com/css2?family=Montserrat:wght@400;600&display=swap' rel='stylesheet'>");
//            out.println("<style>");
//            out.println("body { font-family: 'Montserrat', sans-serif; background-color: #f4f4f9; padding: 20px; color: #333; }");
//            out.println("h1 { color: #1a1a72; font-weight: 600; }");
//            out.println("ul { list-style-type: none; padding: 0; }");
//            out.println("li { background-color: #fff; padding: 10px; margin-bottom: 10px; border-radius: 5px; border: 1px solid #ddd; }");
//            out.println("form { margin-top: 20px; }");
//            out.println("input[type='text'], input[type='number'] { padding: 8px; width: 200px; margin-bottom: 10px; border: 1px solid #ccc; border-radius: 4px; }");
//            out.println("button, input[type='submit'] { background-color: #ff5733; color: white; border: none; padding: 10px 20px; font-size: 16px; cursor: pointer; border-radius: 5px; }");
//            out.println("button:hover, input[type='submit']:hover { background-color: #e14f2d; }");
//            out.println("a { color: #d9534f; text-decoration: none; font-weight: 600; }");
//            out.println("a:hover { text-decoration: underline; color: #c9302c; }");
//            out.println("</style>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Your Shopping Cart</h1>");
//
//            // Display cart items
//            if (cart.isEmpty()) {
//                out.println("<p>Your cart is empty.</p>");
//            } else {
//                out.println("<ul>");
//                for (CartItem item : cart.values()) {
//                    out.println("<li>" + item.getTitle() + " - Quantity: " + item.getQuantity()
//                            + " <a href='cart?action=remove&title=" + item.getTitle() + "'>Remove</a></li>");
//                }
//                out.println("</ul>");
//            }
//
//            // Add item form
////            out.println("<h3>Add Item</h3>");
////            out.println("<form action='cart' method='post'>");
////            out.println("Title: <input type='text' name='title' required><br>");
////            out.println("Quantity: <input type='number' name='quantity' required><br>");
////            out.println("<input type='hidden' name='action' value='add'>");
////            out.println("<input type='submit' value='Add to Cart'>");
////            out.println("</form>");
//            out.println(" <a href=\"/web-app/view-books\"> Back to Catalogue</a>");
//
//            out.println(" <a href=\"/web-app/view-books\">Proceed to checkout</a>");
//
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // Handle the HTTP GET method
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    // Handle the HTTP POST method
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    // Return a short description of the servlet
//    @Override
//    public String getServletInfo() {
//        return "Cart Servlet that allows users to add/remove items and view their cart.";
//    }
//}
