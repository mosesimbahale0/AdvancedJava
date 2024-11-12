<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.kca.web.app.CartItem" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Your Cart - TechBook</title>

        <style>
            body {
                font-family: 'Ubuntu', sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
                color: #333;
            }

            header {
                background-color: #fff;
                color: #333;
                padding: 1rem 2rem;
                display: flex;
                justify-content: space-between;
                align-items: center;
                border-bottom: 1px solid #ddd;
                position: fixed;
                top: 0;
                right: 0;
                left: 0;
                z-index: 100;
            }

            header h1 {
                font-size: 2rem;
                font-weight: 700;
                margin: 0;
            }

            header nav {
                display: flex;
                gap: 1.5rem;
            }

            header nav a {
                color: #333;
                text-decoration: none;
                font-weight: 500;
                transition: color 0.3s ease;
            }

            header nav a:hover {
                color: #ff9800;
            }

            main {
                max-width: 1200px;
                margin: 80px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 8px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }

            h1 {
                font-size: 2rem;
                font-weight: 600;
                margin-bottom: 1.5rem;
            }

            .cart-list {
                list-style: none;
                padding: 0;
                margin: 0;
            }

            .cart-item {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 1rem;
                margin-bottom: 1rem;
                background-color: #f9f9f9;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            }

            .cart-detail {
                font-size: 1rem;
                max-width: 70%;
            }

            .cart-detail strong {
                font-weight: 600;
            }

            .cart-item a {
                color: #ff9800;
                text-decoration: none;
                font-weight: 500;
            }

            .cart-item a:hover {
                text-decoration: underline;
            }

            .actions {
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-top: 1.5rem;
                padding-top: 1.5rem;
                border-top: 1px solid #ddd;
            }

            .actions a {
                background-color: #333;
                color: #fff;
                padding: 0.75rem 1.5rem;
                text-decoration: none;
                border-radius: 5px;
                font-weight: 600;
                transition: background-color 0.3s ease;
            }

            .actions a:hover {
                background-color: #ff9800;
            }

            .empty-cart-message {
                text-align: center;
                font-size: 1.2rem;
                color: #777;
                margin-top: 2rem;
            }

            @media (max-width: 768px) {
                header nav {
                    display: flex;
                    flex-direction: column;
                    gap: 1rem;
                }

                main {
                    margin: 60px auto;
                    padding: 10px;
                }

                .cart-item {
                    flex-direction: column;
                    align-items: flex-start;
                }

                .actions {
                    flex-direction: column;
                    gap: 1rem;
                }
            }
        </style>
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
            <p class="empty-cart-message">Your cart is empty. <a href="/web-app/view-books">Browse books</a></p>
            <% } else { %>
            <ul class="cart-list">
                <% for (CartItem item : cart.values()) { %>
                <li class="cart-item">
                    <div class="cart-detail">
                        <strong>Title:</strong> <span><%= item.getTitle() %></span><br>
                        <strong>Quantity:</strong> <span><%= item.getQuantity() %></span><br>
                        <a href="cart?action=remove&title=<%= item.getTitle() %>">Remove</a>
                    </div>
                </li>
                <% } %>
            </ul>
            <div class="actions">
                <a href="/web-app/view-books">Back to Catalogue</a>
                <a href="/web-app/checkout">Proceed to Checkout</a>
            </div>
            <% } %>
        </main>
    </body>
</html>
