<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.kca.web.app.CartItem" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Cart</title>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@400;500;700&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/web-app/css/style.css">
    </head>
    <body>
        <header>
            <h1>TechBook</h1>
            <nav>
                <a href="/web-app/register">Register</a>
                <a href="/web-app/view-books">Books</a>
            </nav>
        </header>

        <main>
            <h1>Your Shopping Cart</h1>
            <%
                Map<String, CartItem> cart = (Map<String, CartItem>) session.getAttribute("cart");
                if (cart == null || cart.isEmpty()) {
            %>
            <p>Your cart is empty.</p>
            <% } else { %>
            <ul>
                <% for (CartItem item : cart.values()) {%>
                <li>
                    <%= item.getTitle()%> - Quantity: <%= item.getQuantity()%>
                    <a href="cart?action=remove&title=<%= item.getTitle()%>">Remove</a>
                </li>
                <% } %>
            </ul>
            <% }%>
            <a href="/web-app/view-books">Back to Catalogue</a> |
            <a href="/web-app/checkout">Proceed to Checkout</a>
        </main>

        <footer>
            <p>&copy; 2024 TechBook Solutions. All Rights Reserved.</p>
        </footer>
    </body>
</html>
